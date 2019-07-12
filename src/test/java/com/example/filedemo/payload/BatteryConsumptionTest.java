package com.example.filedemo.payload;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BatteryConsumptionTest {

	@Test
	public void computePercentages_valid() throws Exception {
        BatteryConsumption batteryConsumption = new BatteryConsumption(1000, 950, 750);
        
        assertEquals(95, batteryConsumption.getStartingVolumePercentage());
        assertEquals(75, batteryConsumption.getEndingVolumePercentage());
	}

}
