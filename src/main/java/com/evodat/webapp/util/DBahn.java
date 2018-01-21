package com.evodat.webapp.util;

import java.util.Date;

import com.picotel.spider.HttpMethod;
import com.picotel.spider.annotation.DateConverter;
import com.picotel.spider.annotation.Spider;
import com.picotel.spider.annotation.Xpath;

@Spider(url = "https://reiseauskunft.bahn.de", path = "bin/bhftafel.exe/dn?ld=967&protocol=https:&rt=1&", method = HttpMethod.POST)
@Xpath(xPathExpr = "//table[@class='result stboard dep']/tr[not (position()=1) and not(@class='browse') and not(@class='current')]")
public class DBahn extends TrafficInfo {

	@Xpath(xPathExpr = "//td[@class='time']")
	@DateConverter(className = DBahnDateConverter.class)
	public void setTime(Date time) {
		this.time = time;
	}

	@Xpath(xPathExpr = "//td[position()=3]/a")
	public void setTrain(String train) {
		this.train = train;
	}

	@Xpath(xPathExpr = "//td[@class='route']/span/a")
	public void setTarget(String target) {
		this.target = target;
	}

	@Xpath(xPathExpr = "//td[@class='platform']/strong")
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@Xpath(xPathExpr = "//td[@class='train']/a/img/@src")
	public void setImage(String image) {
		this.image = image;
	}

	@Xpath(xPathExpr = "//td[@class='ris']/span/span")
	public void setRis(String ris) {
		this.ris = ris;
	}

}
