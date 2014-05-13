package com.evodat.webapp.util.openweather.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class Forecast {

	@XStreamImplicit(itemFieldName = "date")
	private List<Date> dates;

	public List<Date> getDates() {
		return dates;
	}

	public void setDates(List<Date> dates) {
		this.dates = dates;
	}

}
