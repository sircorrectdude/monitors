package com.evodat.webapp.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.picotel.spider.AbstractDateConverter;

public class MvgDateConverter extends AbstractDateConverter {

	private static final Log logger = LogFactory.getLog(MvgDateConverter.class);

	@Override
	public Date convert(String nodeValue) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		int millis = Integer.parseInt(nodeValue) * 1000 * 60;
		calendar.setTimeInMillis(calendar.getTimeInMillis() + millis);
		return calendar.getTime();
	}
}
