package com.evodat.webapp.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.evodat.util.TimeoutMap;
import com.evodat.webapp.model.Lunch;
import com.picotel.spider.SpiderProcessor;

/**
 * @author joris
 * 
 */
public class LunchAction extends BaseAction {

	private static final long serialVersionUID = -3807706317062383178L;

	private static final Log logger = LogFactory.getLog(LunchAction.class);

	private static final SimpleDateFormat SDF = new SimpleDateFormat(
			"EEE, dd.MM.yyyy");

	private static final TimeoutMap<String, Lunch> LUNCH_CACHE = new TimeoutMap<String, Lunch>(
			1000 * 60 * 60); // 1 Stunde

	private Lunch todaysLunch;

	@Override
	public String execute() throws Exception {

		if (LUNCH_CACHE.get("") == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());

			SpiderProcessor spiderProcessor = new SpiderProcessor();
			spiderProcessor.setClassName(Lunch.class.getName());
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
			// logger.info(objects.size());
			for (Object object : objects) {
				Lunch lunch = (Lunch) object;
				// logger.debug(lunch);
				Date parse = SDF.parse(lunch.getDate());
				Calendar parsedCalendar = Calendar.getInstance();
				parsedCalendar.setTime(parse);
				if (calendar.get(Calendar.DATE) == parsedCalendar
						.get(Calendar.DATE)) {
					todaysLunch = lunch;
					LUNCH_CACHE.put("", lunch);
					break;
				}
			}
		}
		todaysLunch = LUNCH_CACHE.get("");

		return SUCCESS;

	}

	public Lunch getTodaysLunch() {
		return todaysLunch;
	}

}
