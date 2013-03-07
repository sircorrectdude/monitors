package com.evodat.webapp.util;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.picotel.spider.HttpMethod;
import com.picotel.spider.annotation.DateConverter;
import com.picotel.spider.annotation.Spider;
import com.picotel.spider.annotation.Xpath;

@Spider(url = "http://www.munich-airport.de", path = "de/consumer/fluginfo/abflug", method = HttpMethod.GET, encoding = "UTF-8")
@com.picotel.spider.annotation.DynamicPath(delimiter = "_", position = 0)
@Xpath(xPathExpr = "//div[@id='flight_info_table']//table/tr[count(td) > 1]")
public class MunichAirport extends TrafficInfo {

	@Xpath(xPathExpr = "//td[@width='50']/input/@value")
	@DateConverter(className = MunichAirportDateConverter.class)
	public void setTime(Date time) {
		this.time = time;
	}

	@Xpath(xPathExpr = "//td[@width='85']/input/@value")
	public void setTrain(String train) {
		this.train = train;
	}

	@Xpath(xPathExpr = "//td[@width='225']/input/@value")
	public void setTarget(String target) {
		this.target = target;
	}

	@Xpath(xPathExpr = "//td[@width='80']/input/@value")
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@Xpath(xPathExpr = "//td[@width='188']/input/@value")
	public void setRis(String ris) {
		this.ris = ris;
	}

	@Override
	public String getImage() {
		return "";
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
