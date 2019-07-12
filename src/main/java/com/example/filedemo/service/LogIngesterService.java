package com.example.filedemo.service;

import com.example.filedemo.exception.InvalidFileException;
import com.example.filedemo.payload.BatteryConsumption;
import com.example.filedemo.property.FileStorageProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class LogIngesterService {

    private String fileName;
    private BatteryConsumption batteryConsumption;
    private FileStorageProperties fileStorageProperties;

    public LogIngesterService() {
    }

    public LogIngesterService(FileStorageProperties fileStorageProperties) {
        this.fileStorageProperties = fileStorageProperties;
    }

    public LogIngesterService withFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    // TODO: Move the file identifier to full file name into a separate service.
	public LogIngesterService withFileIdentifier(String fileIdentifier) {
        Path fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        this.fileName = fileStorageLocation + "/" + fileIdentifier;
		return this;
    }
    
    public BatteryConsumption getBatteryConsumption() {
        return batteryConsumption;
    }

    public LogIngesterService ingest() throws FileNotFoundException {
        if (fileName == null) {
            throw new FileNotFoundException("No fileName was supplied");
        }

        long startingVoltage;
        long endingVoltage;

        final ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileName);

        if (!file.exists()) {
            throw new FileNotFoundException("The file was not found");
        }

        try {
            JsonNode root = mapper.readTree(file);
            JsonNode flightLoggingNode = root.get("message").get("flight_logging");
            JsonNode flightLoggingItemsNode = flightLoggingNode.get("flight_logging_items");
            JsonNode flightLoggingKeysNode = flightLoggingNode.get("flight_logging_keys");
            List<String> keys = mapper.convertValue(flightLoggingKeysNode, List.class);
            int batteryVoltageIndex = keys.indexOf("battery_voltage");
            int numItems = flightLoggingItemsNode.size();

            JsonNode firstItem = flightLoggingItemsNode.get(0);
            JsonNode lastItem = flightLoggingItemsNode.get(numItems - 1);

            startingVoltage = firstItem.get(batteryVoltageIndex).asLong();
            endingVoltage = lastItem.get(batteryVoltageIndex).asLong();
        } catch (IOException e) {
            e.printStackTrace();
            throw new InvalidFileException("Error parsing JSON file");
        }

        this.batteryConsumption = new BatteryConsumption(startingVoltage, endingVoltage);
        return this;
    }

}