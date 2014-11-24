package com.evodat.util;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.evodat.webapp.util.MunichAirport;
import com.picotel.spider.SpiderProcessor;

public class MunichAirportTest {
	private static final Log logger = LogFactory
			.getLog(MunichAirportTest.class);

	@Test
	public void testMunichAirport() {
		String timeStr = "";
		Calendar calendar = Calendar.getInstance(Locale.GERMAN);
		calendar.add(Calendar.MINUTE, 40);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		if (hour < 6) {
			timeStr = "00";
		} else if (hour < 8) {
			timeStr = "06";
		} else if (hour < 10) {
			timeStr = "08";
		} else if (hour < 12) {
			timeStr = "10";
		} else if (hour < 14) {
			timeStr = "12";
		} else if (hour < 16) {
			timeStr = "14";
		} else if (hour < 18) {
			timeStr = "16";
		} else if (hour < 20) {
			timeStr = "18";
		} else if (hour < 22) {
			timeStr = "20";
		} else if (hour > 22) {
			timeStr = "22";
		}

		SpiderProcessor spiderProcessor = new SpiderProcessor();
		spiderProcessor
				.setUrl("http://www.munich-airport.de/de/consumer/fluginfo/abflug/h"
						+ timeStr + "00_de_S.jsp");
		spiderProcessor.setClassName(MunichAirport.class.getName());

		Map<String, String> params = new HashMap<String, String>();
		//		params.put("lsk", "s");
		//		params.put("searchBtn", "SUCHEN");
		//		params.put("sprache", "de");
		//		params.put("tag", "h");
		//		params.put("stunde", new SimpleDateFormat("HH").format(new Date(
		//				new Date().getTime() + 1000 * 60 * 60)));

		//		spiderProcessor.setParams(params);

		List<Object> objects = null;
		try {
			objects = spiderProcessor.getObjects();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Object object : objects) {
			MunichAirport air = (MunichAirport) object;
			logger.info(air);
		}
	}
}
