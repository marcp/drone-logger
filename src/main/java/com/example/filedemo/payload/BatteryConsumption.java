package com.example.filedemo.payload;

import java.util.Objects;

public class BatteryConsumption {

    private long fullChargeVolume;
    private long startingVolume;
    private long endingVolume;
    private long startingVolumePercentage;
    private long endingVolumePercentage;
    
    public BatteryConsumption(long fullChargeVolume, long startingVolume, long endingVolume) {
        this.fullChargeVolume = fullChargeVolume;
        this.startingVolume = startingVolume;
        this.endingVolume = endingVolume;
        
        computePercentages();
    }

    private void computePercentages() {
        this.startingVolumePercentage = this.startingVolume * 100 / this.fullChargeVolume;
        this.endingVolumePercentage = this.endingVolume * 100 / this.fullChargeVolume;
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

    public long getStartingVolumePercentage() {
        return this.startingVolumePercentage;
    }

    public long getEndingVolumePercentage() {
        return this.endingVolumePercentage;
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