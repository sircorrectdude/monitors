package com.evodat.webapp.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.picotel.spider.annotation.Spider;
import com.picotel.spider.annotation.Xpath;

@Spider(url = "https://www.1912-restaurant.de", path = "speisen-getraenke/business-lunch")
// @Spider(url = "http://localhost", path = "test.html")
@Xpath(xPathExpr = "//div[@class='ce_text block']/div")
public class Lunch {

	private String vor;
	private String haupt;
	private String nach;
	private String date;

	public String getVor() {
		return vor;
	}

	@Xpath(xPathExpr = "//div[position()=2]")
	public void setVor(String vor) {
		this.vor = vor;
	}

	public String getHaupt() {
		return haupt;
	}

	@Xpath(xPathExpr = "//div[position()=3]")
	public void setHaupt(String haupt) {
		this.haupt = haupt;
	}

	public String getNach() {
		return nach;
	}

	@Xpath(xPathExpr = "//div[position()=4]")
	public void setNach(String nach) {
		this.nach = nach;
	}

	public String getDate() {
		return date;
	}

	@Xpath(xPathExpr = "//div[@class='menudate']")
	public void setDate(String date) {
		this.date = date;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
