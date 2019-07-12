package com.example.filedemo.payload;

import java.util.Objects;

public class BatteryConsumption {

    private long startingVoltage;
    private long endingVoltage;
    
    public BatteryConsumption(long startingVoltage, long endingVoltage) {
        this.startingVoltage = startingVoltage;
        this.endingVoltage = endingVoltage;
    }
    
    public long getEndingVoltage() {
        return endingVoltage;
    }
    
    public long getStartingVoltage() {
        return startingVoltage;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BatteryConsumption)) {
            return false;
        }
        BatteryConsumption batteryConsumption = (BatteryConsumption) o;
        return startingVoltage == batteryConsumption.startingVoltage
                && endingVoltage == batteryConsumption.endingVoltage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startingVoltage, endingVoltage);
    }
}