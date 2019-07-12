package com.example.filedemo.service;

import com.example.filedemo.payload.BatteryConsumption;

public class LogIngester {

    private String fileName;
    private BatteryConsumption batteryConsumption;

    public LogIngester() {
    }
    
    public LogIngester withFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
    
    public BatteryConsumption getBatteryConsumption() {
        return batteryConsumption;
    }

    public LogIngester ingest() {
        this.batteryConsumption = new BatteryConsumption(31, 15);
        return this;
    }
}