package com.evodat.webapp.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.picotel.spider.SpiderProcessor;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

public class TrafficServlet extends HttpServlet {
	private static final long serialVersionUID = -1932551800499400790L;
	private static Logger logger = Logger.getLogger(TrafficServlet.class);

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List allObjects = new ArrayList();

		Date date = new Date();
		//DBahn
		if (req.getParameter("db") != null) {
			Map<String, String> params = new HashMap<String, String>();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"EE, dd.MM.yy", Locale.GERMAN);

			SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat(
					"HH:mm", Locale.GERMAN);

			params.put("GUIREQProduct_0", "on");
			params.put("GUIREQProduct_1", "on");
			params.put("GUIREQProduct_2", "on");
			params.put("GUIREQProduct_3", "on");
			//		toggle SBahn
			//			params.put("GUIREQProduct_4", "on");
			params.put("REQTrain_name", "");
			params.put("advancedProductMode", "");
			params.put("boardType", "dep");
			String format = simpleDateFormat.format(date);
			//			logger.info(format);
			params.put("date", format);
			params.put("input", "München Hbf");
			params.put("start", "Suchen");
			params.put("time", simpleDateFormatTime.format(date));
			//			logger.info(simpleDateFormatTime.format(date));
			SpiderProcessor spiderProcessor = new SpiderProcessor();
			spiderProcessor.setParams(params);
			spiderProcessor.setClassName(DBahn.class.getName());
			try {
				List<Object> objects = spiderProcessor.getObjects();
				for (Object object : objects) {
					DBahn dbahn = (DBahn) object;
					if (dbahn.getImage() != null) {
						dbahn.image = "" + dbahn.getImage();
					}
					if (dbahn.getTrain() != null) {
						if (dbahn.getTrain().substring(0, 1).equals("S")) {
							dbahn.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
									+ dbahn.getTrain().replaceAll(" ", "") + ".gif");
						}
					}
				}
				allObjects.addAll(objects);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//

		//Mvg
		if (req.getParameter("mvg") != null) {

			// 1. HBF
			Map<String, String> params = new HashMap<String, String>();
			params = new HashMap<String, String>();
			String STATION = "hauptbahnhof";
			params.put("haltestelle", STATION);
			params.put("ubahn", "checked");
			params.put("tram", "checked");
			params.put("bus", "checked");
			params.put("sbahn", "checked");

			SpiderProcessor spiderProcessor = new SpiderProcessor();
			spiderProcessor.setParams(params);
			spiderProcessor.setClassName(Mvg.class.getName());
			try {
				List<Object> objects = spiderProcessor.getObjects();
				for (Object object : objects) {
					Mvg mvg = (Mvg) object;
					mvg.setStation("Hauptbahnhof");
					if (mvg.getTrain() != null) {
						String firstLetter = mvg.getTrain().substring(0, 1);
						if (firstLetter.equals("N")) {
							mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
									+ firstLetter
									+ "-"
									+ mvg.getTrain().substring(1) + ".gif");
						} else if (firstLetter.equals("U")) {
							mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
									+ firstLetter
									+ "-"
									+ mvg.getTrain().substring(1) + ".gif");
							mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/U-Bahn.gif";
						} else if (firstLetter.equals("S")) {
							mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
									+ firstLetter
									+ mvg.getTrain().substring(1,
											mvg.getTrain().length()) + ".gif");
							mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/S-Bahn.gif";
						} else if (firstLetter.equals("M")) {
							mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
									+ "M-"
									+ mvg.getTrain() + ".gif");
							mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/S-Bahn.gif";
						}
						else {
							mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
									+ "T-" + mvg.getTrain() + ".gif");
							mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/Tram.gif";
						}
					}
				}
				allObjects.addAll(objects);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// HBF SÜD
			params = new HashMap<String, String>();
			STATION = "hauptbahnhof+nord";
			params.put("haltestelle", STATION);
			params.put("ubahn", "checked");
			params.put("tram", "checked");
			params.put("bus", "checked");
			params.put("sbahn", "checked");

			spiderProcessor = new SpiderProcessor();
			spiderProcessor.setParams(params);
			spiderProcessor.setClassName(Mvg.class.getName());
			try {
				List<Object> objects = spiderProcessor.getObjects();
				for (Object object : objects) {
					Mvg mvg = (Mvg) object;
					mvg.setStation("Hauptbahnhof Nord");
					if (mvg.getTrain() != null) {
						String firstLetter = mvg.getTrain().substring(0, 1);
						if (firstLetter.equals("N")) {
							mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
									+ firstLetter
									+ "-"
									+ mvg.getTrain().substring(1) + ".gif");
						} else if (firstLetter.equals("U")) {
							mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
									+ firstLetter
									+ "-"
									+ mvg.getTrain().substring(1) + ".gif");
							mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/U-Bahn.gif";
						} else if (firstLetter.equals("S")) {
							mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
									+ firstLetter
									+ mvg.getTrain().substring(1,
											mvg.getTrain().length()) + ".gif");
							mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/S-Bahn.gif";
						} else {
							mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/Bus.gif";
							if ("100".equals(mvg.getTrain())) {
								mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/S-100.gif");
							} else if ("58".equals(mvg.getTrain())) {
								mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/B-58.gif");
							} else {
								mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
										+ "T-" + mvg.getTrain() + ".gif");
								mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/Tram.gif";
							}
						}
					}
				}
				allObjects.addAll(objects);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// HBF NORD
			params = new HashMap<String, String>();
			STATION = "hauptbahnhof+s%FCd";
			params.put("haltestelle", STATION);
			params.put("ubahn", "checked");
			params.put("tram", "checked");
			params.put("bus", "checked");
			params.put("sbahn", "checked");

			spiderProcessor = new SpiderProcessor();
			spiderProcessor.setParams(params);
			spiderProcessor.setClassName(Mvg.class.getName());
			try {
				List<Object> objects = spiderProcessor.getObjects();
				for (Object object : objects) {
					Mvg mvg = (Mvg) object;
					mvg.setStation("Hauptbahnhof Süd");
					if (mvg.getTrain() != null) {
						String firstLetter = mvg.getTrain().substring(0, 1);
						if (firstLetter.equals("N")) {
							mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
									+ firstLetter
									+ "-"
									+ mvg.getTrain().substring(1) + ".gif");
						} else if (firstLetter.equals("U")) {
							mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
									+ firstLetter
									+ "-"
									+ mvg.getTrain().substring(1) + ".gif");
							mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/U-Bahn.gif";
						} else if (firstLetter.equals("S")) {
							mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
									+ firstLetter
									+ mvg.getTrain().substring(1,
											mvg.getTrain().length()) + ".gif");
							mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/S-Bahn.gif";
						} else {
							mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
									+ "T-" + mvg.getTrain() + ".gif");
							mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/Tram.gif";
						}
					}
				}
				allObjects.addAll(objects);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		//

		//Airport
		if (req.getParameter("air") != null) {
			String timeStr = "";
			Calendar calendar = Calendar.getInstance();

			//Sommerzeit Bug??
			calendar.add(Calendar.MINUTE, 60);

			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			//			logger.info(hour);
			if (hour < 6) {
				timeStr = "00";
			} else if (hour < 8) {
				timeStr = "06";
			} else if (hour < 10) {
				timeStr = "08";
			} else if (hour < 12) {
				timeStr = "10";
			} else if (hour < 14) {
				timeStr = "12";
			} else if (hour < 16) {
				timeStr = "14";
			} else if (hour < 18) {
				timeStr = "16";
			} else if (hour < 20) {
				timeStr = "18";
			} else if (hour < 22) {
				timeStr = "20";
			} else if (hour > 22) {
				timeStr = "22";
			}
			logger.info(timeStr);
			SpiderProcessor spiderProcessor = new SpiderProcessor();
			spiderProcessor
					.setUrl("http://www.munich-airport.de/de/consumer/fluginfo/abflug/h"
							+ timeStr + "00_de_S.jsp");
			spiderProcessor.setClassName(MunichAirport.class.getName());
			try {
				allObjects.addAll(spiderProcessor.getObjects());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			/* next page*/

			spiderProcessor = new SpiderProcessor();
			calendar.add(Calendar.MINUTE, 120);
			hour = calendar.get(Calendar.HOUR_OF_DAY);
			if (hour < 6) {
				timeStr = "00";
			} else if (hour < 8) {
				timeStr = "06";
			} else if (hour < 10) {
				timeStr = "08";
			} else if (hour < 12) {
				timeStr = "10";
			} else if (hour < 14) {
				timeStr = "12";
			} else if (hour < 16) {
				timeStr = "14";
			} else if (hour < 18) {
				timeStr = "16";
			} else if (hour < 20) {
				timeStr = "18";
			} else if (hour < 22) {
				timeStr = "20";
			} else if (hour > 22) {
				timeStr = "22";
			}
			logger.info(timeStr);
			spiderProcessor = new SpiderProcessor();
			spiderProcessor
					.setUrl("http://www.munich-airport.de/de/consumer/fluginfo/abflug/h"
							+ timeStr + "00_de_S.jsp");
			spiderProcessor.setClassName(MunichAirport.class.getName());
			try {
				allObjects.addAll(spiderProcessor.getObjects());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			/* next page*/

			spiderProcessor = new SpiderProcessor();
			calendar.add(Calendar.MINUTE, 120);
			hour = calendar.get(Calendar.HOUR_OF_DAY);
			if (hour < 6) {
				timeStr = "00";
			} else if (hour < 8) {
				timeStr = "06";
			} else if (hour < 10) {
				timeStr = "08";
			} else if (hour < 12) {
				timeStr = "10";
			} else if (hour < 14) {
				timeStr = "12";
			} else if (hour < 16) {
				timeStr = "14";
			} else if (hour < 18) {
				timeStr = "16";
			} else if (hour < 20) {
				timeStr = "18";
			} else if (hour < 22) {
				timeStr = "20";
			} else if (hour > 22) {
				timeStr = "22";
			}
			logger.info(timeStr);
			spiderProcessor = new SpiderProcessor();
			spiderProcessor
					.setUrl("http://www.munich-airport.de/de/consumer/fluginfo/abflug/h"
							+ timeStr + "00_de_S.jsp");
			spiderProcessor.setClassName(MunichAirport.class.getName());
			try {
				allObjects.addAll(spiderProcessor.getObjects());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			/* next page

			spiderProcessor = new SpiderProcessor();
			calendar.add(Calendar.MINUTE, 120);
			hour = calendar.get(Calendar.HOUR_OF_DAY);
			if (hour < 6) {
				timeStr = "00";
			} else if (hour < 8) {
				timeStr = "06";
			} else if (hour < 10) {
				timeStr = "08";
			} else if (hour < 12) {
				timeStr = "10";
			} else if (hour < 14) {
				timeStr = "12";
			} else if (hour < 16) {
				timeStr = "14";
			} else if (hour < 18) {
				timeStr = "16";
			} else if (hour < 20) {
				timeStr = "18";
			} else if (hour < 22) {
				timeStr = "20";
			} else if (hour > 22) {
				timeStr = "22";
			}
			logger.info(timeStr);
			spiderProcessor = new SpiderProcessor();
			spiderProcessor
					.setUrl("http://www.munich-airport.de/de/consumer/fluginfo/abflug/h"
							+ timeStr + "00_de_S.jsp");
			spiderProcessor.setClassName(MunichAirport.class.getName());
			try {
				allObjects.addAll(spiderProcessor.getObjects());
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			*/
		}
		//

		Collections.sort(allObjects);
		Collections.reverse(allObjects);

		for (Object object : allObjects) {
			TrafficInfo trafficInfo = (TrafficInfo) object;
			logger.debug(trafficInfo);
		}
		//		List<Object> obj = new ArrayList<Object>(allObjects);
		//		//Format time for view
		for (Object object : allObjects) {
			TrafficInfo trafficInfo = (TrafficInfo) object;
			//					if (trafficInfo.getTrain() == null
			//							|| trafficInfo.getTrain().trim().equals("")) {
			//						continue;
			//					}
			if (trafficInfo.getTime() != null) {
				//				trafficInfo.timeShift = new SimpleDateFormat("m")
				//						.format(new Date(trafficInfo.getTime().getTime() + 1000
				//								* 60 * 60 - date.getTime()));

				trafficInfo.timeShift = String.valueOf(((trafficInfo.getTime()
						.getTime()) - date.getTime()) / (1000 * 60));

				//				logger.info(trafficInfo.timeShift);
				trafficInfo.setTimeString(new SimpleDateFormat("HH:mm",
						Locale.GERMAN).format(new Date(trafficInfo.getTime()
						.getTime()
				//Somerzeit Bug?
				+ 1000 * 60 * 60
						)));
				//						obj.add(trafficInfo);
			}

		}
		// Serialize to JSON

		TrafficInfoDTO trafficInfoDTO = new TrafficInfoDTO();
		trafficInfoDTO.setAllObjects(allObjects);
		trafficInfoDTO.setTime(new SimpleDateFormat("HH:mm", Locale.GERMAN)
				.format(new Date().getTime()
				//Somerzeit Bug?
				+ 1000 * 60 * 60
				));

		XStream xstreamOut = new XStream(new JsonHierarchicalStreamDriver() {
			public HierarchicalStreamWriter createWriter(Writer writer) {
				return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
			}
		});

		String jsonString = xstreamOut.toXML(trafficInfoDTO);

		PrintWriter out = resp.getWriter();
		out.print(jsonString);
		resp.setContentType("application/json");
		out.flush();
		out.close();

	}
}
