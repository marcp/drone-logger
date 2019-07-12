package com.example.filedemo.payload;

import java.util.Objects;

public class BatteryConsumption {

    private long fullChargeVolume;
    private long startingVolume;
    private long endingVolume;
    
    public BatteryConsumption(long fullChargeVolume, long startingVolume, long endingVolume) {
        this.startingVolume = startingVolume;
        this.endingVolume = endingVolume;
    }

    public long getFullChargeVolume() {
        return this.fullChargeVolume;
    }

    public long getStartingVolume() {
        return this.startingVolume;
    }

    public long getEndingVolume() {
        return this.endingVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BatteryConsumption)) {
            return false;
        }
        BatteryConsumption batteryConsumption = (BatteryConsumption) o;
        return fullChargeVolume == batteryConsumption.fullChargeVolume && startingVolume == batteryConsumption.startingVolume && endingVolume == batteryConsumption.endingVolume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullChargeVolume, startingVolume, endingVolume);
    }

}