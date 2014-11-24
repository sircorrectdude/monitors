package com.evodat.webapp.util;

import java.util.Date;

import com.picotel.spider.annotation.DateConverter;
import com.picotel.spider.annotation.Spider;
import com.picotel.spider.annotation.Xpath;

@Spider(url = "http://www.mvg-live.de", path = "ims/dfiStaticAnzeige.svc", encoding = "ISO-8859-1")
@Xpath(xPathExpr = "//table[@class='departureTable departureView']/tr[(@class='rowOdd') or (@class='rowEven')]")
public class Mvg extends TrafficInfo {

	public String station;

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	@Xpath(xPathExpr = "//td[@class='inMinColumn']")
	@DateConverter(className = MvgDateConverter.class)
	public void setTime(Date time) {
		this.time = time;
	}

	@Xpath(xPathExpr = "//td[@class='lineColumn']")
	public void setTrain(String train) {
		this.train = train;
	}

	@Xpath(xPathExpr = "//td[@class='stationColumn']")
	public void setTarget(String target) {
		this.target = target;
	}

}
