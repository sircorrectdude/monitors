package com.evodat.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.evodat.webapp.util.DBahn;
import com.picotel.spider.SpiderProcessor;

public class DBahnTest {

	private static final Log logger = LogFactory.getLog(DBahnTest.class);

	@Test
	public void testDBahn() {
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
		params.put("GUIREQProduct_4", "on");
		params.put("REQTrain_name", "");
		params.put("advancedProductMode", "");
		params.put("boardType", "dep");
		String format = simpleDateFormat.format(date);
		logger.info(format);
		params.put("date", format);
		params.put("input", "München Hbf");
		//		params.put("inputRef", "München Hbf#8000261");
		params.put("start", "Suchen");
		params.put("time", simpleDateFormatTime.format(date));

		SpiderProcessor spiderProcessor = new SpiderProcessor();
		spiderProcessor.setParams(params);
		spiderProcessor.setClassName(DBahn.class.getName());
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
		//		logger.info(objects.size());
		for (Object object : objects) {
			DBahn dBahn = (DBahn) object;
			logger.info(dBahn.getImage());
			logger.info(dBahn.getImageGeneral());
			logger.info(dBahn.getTrain());
			logger.info(dBahn.getRis());
		}
	}
}
