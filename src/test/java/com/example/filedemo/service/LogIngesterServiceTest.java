package com.example.filedemo.service;

import com.example.filedemo.payload.BatteryConsumption;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class LogIngesterServiceTest {

	@Test(expected=FileNotFoundException.class)
	public void ingest_nullFile() throws Exception {
		LogIngesterService logIngester = new LogIngesterService();
		logIngester.ingest();
	}

	@Test(expected=FileNotFoundException.class)
	public void ingest_missingFile() throws Exception {
		LogIngesterService logIngester = new LogIngesterService();
		logIngester.withFileName("barney.log").ingest();
	}

	@Test
	public void ingest_smallFile() throws Exception {
		LogIngesterService logIngester = new LogIngesterService();
		logIngester.withFileName("/Users/marc/play/skyward/logfile.txt").ingest();

		BatteryConsumption batteryConsumption = new BatteryConsumption(15977, 15977);

		assertEquals(batteryConsumption, logIngester.getBatteryConsumption());
	}
}
