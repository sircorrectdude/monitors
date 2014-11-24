package com.evodat.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.evodat.webapp.util.Mvg;
import com.picotel.spider.SpiderProcessor;

public class MvgTest {

	private static final Log logger = LogFactory.getLog(MvgTest.class);

	@Test
	public void testMvg() {

		Map<String, String> params = new HashMap<String, String>();
		params.put("haltestelle", "hauptbahnhof");
		params.put("ubahn", "checked");
		params.put("tram", "checked");
		params.put("bus", "checked");

		SpiderProcessor spiderProcessor = new SpiderProcessor();
		spiderProcessor.setParams(params);
		spiderProcessor.setClassName(Mvg.class.getName());
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
			Mvg mvg = (Mvg) object;
			//			logger.info(mvg.getTime());
			if (mvg.getTrain() != null) {
				mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
						+ mvg.getTrain().replaceAll("-", "") + ".gif");
				if (mvg.getTrain().equals("U1")) {
					mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/U-1.gif");
				}
			}
		}
	}
}
