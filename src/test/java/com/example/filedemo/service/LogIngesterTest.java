package com.example.filedemo.service;

import com.example.filedemo.payload.BatteryConsumption;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class LogIngesterTest {

	@Test(expected=FileNotFoundException.class)
	public void ingest_nullFile() throws Exception {
		LogIngester logIngester = new LogIngester();
		logIngester.ingest();
	}

	@Test(expected=FileNotFoundException.class)
	public void ingest_missingFile() throws Exception {
		LogIngester logIngester = new LogIngester();
		logIngester.withFileName("barney.log").ingest();
	}

	@Test
	public void ingest_smallFile() throws Exception {
		LogIngester logIngester = new LogIngester();
		logIngester.withFileName("/Users/marc/play/skyward/logfile.txt").ingest();

		BatteryConsumption batteryConsumption = new BatteryConsumption(15977, 15977);

		assertEquals(batteryConsumption, logIngester.getBatteryConsumption());
	}
}
