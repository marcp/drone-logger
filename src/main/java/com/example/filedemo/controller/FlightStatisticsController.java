package com.example.filedemo.controller;

import com.example.filedemo.payload.BatteryConsumption;
import com.example.filedemo.property.FileStorageProperties;
import com.example.filedemo.service.LogIngesterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/flightStatistics")
public class FlightStatisticsController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageProperties fileStorageProperties;

    @GetMapping("/{fileIdentifier:.+}/batteryConsumption")
    public ResponseEntity<BatteryConsumption> batteryConsumption(@PathVariable String fileIdentifier, HttpServletRequest request) {

        LogIngesterService logIngester = new LogIngesterService(fileStorageProperties);

        try {
            logIngester.withFileIdentifier(fileIdentifier).ingest();

            return ResponseEntity.ok(logIngester.getBatteryConsumption());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR); 
        }
    }

}