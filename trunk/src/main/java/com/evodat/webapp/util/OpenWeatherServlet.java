package com.evodat.webapp.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.evodat.util.TimeoutMap;
import com.evodat.webapp.util.openweather.model.City;
import com.evodat.webapp.util.openweather.model.Date;
import com.evodat.webapp.util.openweather.model.Time;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

/**
 * @author joris
 *
 */
public class OpenWeatherServlet extends HttpServlet {

	private static final long serialVersionUID = 250447754745474886L;
	private static final String API_URL = "http://api.wetter.com/forecast/weather/city/DE0006515/project/dolomit/cs/8fa99411d224aca3a7ea00f27d42c976";
	private static final Locale GERMAN = Locale.GERMAN;
	private static Logger logger = Logger.getLogger(OpenWeatherServlet.class);
	// a short term cache for Product
	/** The Constant PRODUCT_CACHE. */
	private static final TimeoutMap<String, Forecast> FORECAST_CACHE = new TimeoutMap<String, Forecast>(
			1000 * 60 * 60); // 1 Stunde

	private String days;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if (req.getParameter("days") != null) {
			days = req.getParameter("days");
		} else {
			days = new Integer(3).toString();
		}

		XStream xstream = new XStream();
		Forecast forecast;

		if (FORECAST_CACHE.get("") == null) {
			logger.info("request...");
			String xmlString = Util
					.convertStreamToString(Util.getPage(API_URL));

			xstream.processAnnotations(City.class);
			City city = (City) xstream.fromXML(xmlString);
			forecast = new Forecast();
			List<Day> days = new ArrayList<Day>();
			int count = 0;
			for (Date date : city.getForecast().getDates()) {
				Day day = new Day();
				java.util.Date dateValue = null;
				try {
					dateValue = new SimpleDateFormat("yyyy-MM-dd").parse(date
							.getValue());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				day.setName(new SimpleDateFormat("E", GERMAN).format(dateValue)
						+ ". / "
						+ new SimpleDateFormat("E", Locale.ENGLISH)
								.format(dateValue) + ".");
				day.setDateString(new SimpleDateFormat("dd. MMM. yyyy", GERMAN)
						.format(dateValue));
				for (Time time : date.getTimes()) {
					if (time.getValue().equals("06:00")) {
						day.setMorning(time.getTn());
						day.setMorningImg("d_" + time.getW().substring(0, 1)
								+ "_b");
						day.setMorningPc(time.getPc());
						day.setMorningWd_txt(time.getWd_txt());
						day.setMorningWs(time.getWs());
						day.setMorningF(String.valueOf(((Integer.parseInt(time
								.getTn()) * 9) / 5) + 32));
					}
					if (time.getValue().equals("11:00")) {
						day.setMiday(time.getTn());
						day.setMidayImg("d_" + time.getW().substring(0, 1)
								+ "_b");
						day.setMidayPc(time.getPc());
						day.setMidayWd_txt(time.getWd_txt());
						day.setMidayWs(time.getWs());
						day.setMidayF(String.valueOf(((Integer.parseInt(time
								.getTn()) * 9) / 5) + 32));
					}
					if (time.getValue().equals("17:00")) {
						day.setEvening(time.getTn());
						day.setEveningImg("d_" + time.getW().substring(0, 1)
								+ "_b");
						day.setEveningPc(time.getPc());
						day.setEveningWd_txt(time.getWd_txt());
						day.setEveningWs(time.getWs());
						day.setEveningF(String.valueOf(((Integer.parseInt(time
								.getTn()) * 9) / 5) + 32));
					}
					if (time.getValue().equals("23:00")) {
						day.setNight(time.getTn());
						day.setNightImg("d_" + time.getW().substring(0, 1)
								+ "_b");
						day.setNightPc(time.getPc());
						day.setNightWd_txt(time.getWd_txt());
						day.setNightWs(time.getWs());
						day.setNightF(String.valueOf(((Integer.parseInt(time
								.getTn()) * 9) / 5) + 32));
					}
				}
				if (count < Integer.valueOf(this.days)) {
					days.add(day);
				}
				count++;
			}
			forecast.setDays(days);
			FORECAST_CACHE.put("", forecast);
		} else {
			forecast = FORECAST_CACHE.get("");
		}
		// Serialize to JSON
		XStream xstreamOut = new XStream(new JsonHierarchicalStreamDriver() {
			public HierarchicalStreamWriter createWriter(Writer writer) {
				return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
			}
		});
		xstream.processAnnotations(Forecast.class);

		String jsonString = xstreamOut.toXML(forecast);

		PrintWriter out = resp.getWriter();

		out.print(jsonString);
		out.flush();
		out.close();

	}
}
