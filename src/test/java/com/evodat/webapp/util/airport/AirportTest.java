package com.evodat.webapp.util.airport;

import java.util.List;

import org.junit.Test;

import com.evodat.webapp.util.TrafficInfo;

public class AirportTest {

	@Test
	public void testPull() throws Exception {
		Airport airport = new Airport();
		List<TrafficInfo> pull = airport.pull(10);
		for(TrafficInfo info: pull){
			System.out.println(info);
		}
	}

}
