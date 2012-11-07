package com.evodat.webapp.util.openweather.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(value = "city")
public class City {

	private String city_code;
	private String name;
	private String post_code;

	@XStreamAlias(value = "credit")
	private Credit credit;

	@XStreamAlias(value = "forecast")
	private Forecast forecast;

	public Forecast getForecast() {
		return forecast;
	}

	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
	}

	public String getCity_code() {
		return city_code;
	}

	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPost_code() {
		return post_code;
	}

	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

}
