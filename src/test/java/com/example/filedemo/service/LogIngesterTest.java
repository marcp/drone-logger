package com.example.filedemo.service;

import com.example.filedemo.payload.BatteryConsumption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogIngesterTest {

	@Test
	public void batteryConsumption() throws Exception {
		LogIngester logIngster = new LogIngester();

		BatteryConsumption batteryConsumption = new BatteryConsumption(31, 15);
		
		assertEquals(batteryConsumption, logIngster.withFileName("barney").ingest().getBatteryConsumption());
	}

}
