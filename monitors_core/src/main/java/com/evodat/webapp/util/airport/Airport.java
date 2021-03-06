package com.evodat.webapp.util.airport;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import com.evodat.webapp.util.MunichAirport;
import com.evodat.webapp.util.TrafficInfo;
import com.evodat.webapp.util.Util;

public class Airport {

	public final String domain = "http://www.munich-airport.de";
	private static Logger logger = Logger.getLogger(Airport.class);
	private List<TrafficInfo> allObjects = new ArrayList<TrafficInfo>();
	DefaultHttpClient httpclient = new DefaultHttpClient();

	public static void main(String[] args) {
		Airport airport = new Airport();
		try {
			airport.pull();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (TrafficInfo munichAirport : airport.getAllObjects()) {
			logger.info(munichAirport);
		}

	}

	public List<TrafficInfo> pull() throws IOException {
		String url = domain + "/de/consumer/fluginfo/dep/index.jsp";
		getPageBody(url);
		return allObjects;

	}

	private void getPageBody(String url) throws ClientProtocolException,
			IOException {

		InputStream page = Util.getPage(url, httpclient);
		String body = Util.convertStreamToString(page);
		List<TrafficInfo> pageObjects = pageObjects(body);
		allObjects.addAll(pageObjects);

		Pattern nextPattern = Pattern.compile("<div class=\"later\">\\s*"
				+ "<a href=\"([^\"]*)\">Später</a>\\s*" + "</div>");
		Matcher nextmatcher = nextPattern.matcher(body);
		if (nextmatcher.find()) {
			String nextPath = nextmatcher.group(1);
			// logger.info(nextPath);
			getPageBody(domain + nextPath);
		}

		// return pageBody;
	}

	private List<TrafficInfo> pageObjects(String body)
			throws ClientProtocolException, IOException {
		List<TrafficInfo> allObjects = new ArrayList<TrafficInfo>();

		Pattern pattern = Pattern.compile("knr=([^\"]*)\">([^<]*)</a></td>\\s*"
				+ "<td align=\"left\">([^<]*)</td>\\s*"
				+ "<td align=\"left\">([^<]*)</td>\\s*"
				+ "<td align=\"left\">([^<]*)</td>\\s*"
				+ "<td align=\"left\">([^<]*)</td>\\s*"
				+ "<td align=\"left\">([^<]*)</td>");
		Matcher matcher = pattern.matcher(body);
		while (matcher.find()) {

			MunichAirport trafficInfo = new MunichAirport();

			String flightNr = matcher.group(2);
			// logger.info(flightNr);
			trafficInfo.setTrain(flightNr);

			String target = matcher.group(3);
			// logger.info(target);
			trafficInfo.setTarget(target);

			String time = matcher.group(4);
			// logger.info(time);
			Calendar calendar = Calendar.getInstance();
			Date parse;
			try {
				parse = new SimpleDateFormat("HH:mm").parse(time);
				Calendar parsed = Calendar.getInstance();
				parsed.setTime(parse);
				calendar.set(Calendar.HOUR_OF_DAY,
						parsed.get(Calendar.HOUR_OF_DAY));
				calendar.set(Calendar.MINUTE, parsed.get(Calendar.MINUTE));
				trafficInfo.setTime(calendar.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// String expectedTime = matcher.group(5);
			// logger.info(expectedTime);

			String terminal = matcher.group(6);
			// logger.info(terminal);
			trafficInfo.setPlatform(terminal);

			String status = matcher.group(7);
			// logger.info(status);
			trafficInfo.setRis(status);
			allObjects.add(trafficInfo);

		}
		return allObjects;

	}

	public List<TrafficInfo> getAllObjects() {
		return allObjects;
	}

}
