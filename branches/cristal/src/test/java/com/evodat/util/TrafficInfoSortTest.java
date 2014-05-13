package com.evodat.util;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.evodat.webapp.util.DBahn;
import com.evodat.webapp.util.Mvg;
import com.evodat.webapp.util.TrafficInfo;
import com.picotel.spider.SpiderProcessor;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

public class TrafficInfoSortTest {

	private static final Log logger = LogFactory
			.getLog(TrafficInfoSortTest.class);

	@Test
	public void testSort() {
		List allObjects = new ArrayList();

		//DBahn
		Map<String, String> params = new HashMap<String, String>();
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"EE, dd.MM.yy", Locale.GERMAN);

		SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm",
				Locale.GERMAN);

		params.put("GUIREQProduct_0", "on");
		params.put("GUIREQProduct_1", "on");
		params.put("GUIREQProduct_2", "on");
		params.put("GUIREQProduct_3", "on");
		//		toggle SBahn
		params.put("GUIREQProduct_4", "on");
		params.put("REQTrain_name", "");
		params.put("advancedProductMode", "");
		params.put("boardType", "dep");
		String format = simpleDateFormat.format(date);
		logger.info(format);
		params.put("date", format);
		params.put("input", "München Hbf");
		params.put("start", "Suchen");
		params.put("time", simpleDateFormatTime.format(date));

		SpiderProcessor spiderProcessor = new SpiderProcessor();
		spiderProcessor.setParams(params);
		spiderProcessor.setClassName(DBahn.class.getName());
		try {
			List<Object> objects = spiderProcessor.getObjects();
			for (Object object : objects) {
				DBahn dbahn = (DBahn) object;
				if (dbahn.getImage() != null) {
					dbahn.image = "http://reiseauskunft.bahn.de"
							+ dbahn.getImage();
				}
				if (dbahn.getTrain() != null) {
					if (dbahn.getTrain().substring(0, 1).equals("S")) {
						dbahn.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
								+ dbahn.getTrain().replaceAll(" ", "") + ".gif");
					}
				}
			}
			allObjects.addAll(objects);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//

		//Mvg
		params = new HashMap<String, String>();
		params.put("haltestelle", "hauptbahnhof");
		params.put("ubahn", "checked");
		params.put("tram", "checked");
		params.put("bus", "checked");
		//		params.put("sbahn", "checked");

		spiderProcessor = new SpiderProcessor();
		spiderProcessor.setParams(params);
		spiderProcessor.setClassName(Mvg.class.getName());
		try {
			List<Object> objects = spiderProcessor.getObjects();
			for (Object object : objects) {
				Mvg mvg = (Mvg) object;
				if (mvg.getTrain() != null) {
					if (mvg.getTrain().substring(0, 1).equals("U")) {
						mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
								+ mvg.getTrain().substring(0, 1)
								+ "-"
								+ mvg.getTrain().substring(1) + ".gif");
					} else {
						mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
								+ "T-" + mvg.getTrain() + ".gif");
					}
				}
			}
			allObjects.addAll(objects);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//

		//Airport
		/*spiderProcessor = new SpiderProcessor();
		spiderProcessor.setClassName(MunichAirport.class.getName());
		try {
			allObjects.addAll(spiderProcessor.getObjects());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		//

		Collections.sort(allObjects);
		Collections.reverse(allObjects);

		//Format time for view
		for (Object object : allObjects) {
			TrafficInfo trafficInfo = (TrafficInfo) object;
			if (trafficInfo.getTime() != null) {
				trafficInfo.setTimeString(new SimpleDateFormat("HH:mm")
						.format(trafficInfo.getTime()));
			}
		}

		// Serialize to JSON
		XStream xstreamOut = new XStream(new JsonHierarchicalStreamDriver() {
			public HierarchicalStreamWriter createWriter(Writer writer) {
				return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
			}
		});

		String jsonString = xstreamOut.toXML(allObjects);
		logger.info(jsonString);
	}
}
