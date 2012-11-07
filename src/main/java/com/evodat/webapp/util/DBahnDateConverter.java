package com.evodat.webapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.picotel.spider.AbstractDateConverter;

public class DBahnDateConverter extends AbstractDateConverter {

	@Override
	public Date convert(String nodeValue) throws ParseException {
		Calendar now = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new SimpleDateFormat("HH:mm").parse(nodeValue));
		calendar.set(Calendar.YEAR, now.get(Calendar.YEAR));
		calendar.set(Calendar.MONTH, now.get(Calendar.MONTH));
		calendar.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}
}
