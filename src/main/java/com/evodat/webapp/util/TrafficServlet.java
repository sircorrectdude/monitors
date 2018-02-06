package com.evodat.webapp.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.evodat.util.TimeoutMap;
import com.evodat.webapp.util.airport.Airport;
import com.picotel.spider.SpiderProcessor;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

public class TrafficServlet extends HttpServlet {
	private static final long serialVersionUID = -1932551800499400790L;
	private static Logger logger = Logger.getLogger(TrafficServlet.class);

	private static final TimeoutMap<String, List<TrafficInfo>> TRAFFIC_CACHE_AIR = new TimeoutMap<String, List<TrafficInfo>>(
			1000 * 60 * 60); // 1 hour

	private static final TimeoutMap<String, List<Object>> TRAFFIC_CACHE_DB = new TimeoutMap<String, List<Object>>(
			1000 * 60 * 15); // 15 min

	private static final TimeoutMap<String, List<Object>> TRAFFIC_CACHE_MVG = new TimeoutMap<String, List<Object>>(
			1000 * 60 * 1); // 1 min

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List allObjects = new ArrayList();

		Date date = new Date();
		// DBahn
		if (req.getParameter("db") != null) {
			if (TRAFFIC_CACHE_DB.get("TRAFFIC_CACHE_DB") == null) {
//				logger.info("Request DB");
				Map<String, String> params = new HashMap<String, String>();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
						"EE, dd.MM.yy", Locale.GERMAN);

				SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat(
						"HH:mm", Locale.GERMAN);

				params.put("GUIREQProduct_0", "on");
				params.put("GUIREQProduct_1", "on");
				params.put("GUIREQProduct_2", "on");
				params.put("GUIREQProduct_3", "on");
				// toggle SBahn
				// params.put("GUIREQProduct_4", "on");
				params.put("REQTrain_name", "");
				params.put("advancedProductMode", "");
				params.put("boardType", "dep");
				String format = simpleDateFormat.format(date);
				// logger.info(format);
				params.put("date", format);
				params.put("input", "München Hbf");
				params.put("start", "Suchen");
				params.put("time", simpleDateFormatTime.format(date));
				// logger.info(simpleDateFormatTime.format(date));
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

				// second time for next side
				date = new Date(new Date().getTime() + 1000 * 60 * 60);
				params = new HashMap<String, String>();

				params.put("GUIREQProduct_0", "on");
				params.put("GUIREQProduct_1", "on");
				params.put("GUIREQProduct_2", "on");
				params.put("GUIREQProduct_3", "on");
				// toggle SBahn
				// params.put("GUIREQProduct_4", "on");
				params.put("REQTrain_name", "");
				params.put("advancedProductMode", "");
				params.put("boardType", "dep");
				format = simpleDateFormat.format(date);
				// logger.info(format);
				params.put("date", format);
				params.put("input", "München Hbf");
				params.put("start", "Suchen");
				params.put("time", simpleDateFormatTime.format(date));
				// logger.info(simpleDateFormatTime.format(date));
				spiderProcessor = new SpiderProcessor();
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

				// third time for next side
				date = new Date(new Date().getTime() + 1000 * 60 * 120);
				params = new HashMap<String, String>();

				params.put("GUIREQProduct_0", "on");
				params.put("GUIREQProduct_1", "on");
				params.put("GUIREQProduct_2", "on");
				params.put("GUIREQProduct_3", "on");
				// toggle SBahn
				// params.put("GUIREQProduct_4", "on");
				params.put("REQTrain_name", "");
				params.put("advancedProductMode", "");
				params.put("boardType", "dep");
				format = simpleDateFormat.format(date);
				// logger.info(format);
				params.put("date", format);
				params.put("input", "München Hbf");
				params.put("start", "Suchen");
				params.put("time", simpleDateFormatTime.format(date));
				// logger.info(simpleDateFormatTime.format(date));
				spiderProcessor = new SpiderProcessor();
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

				TRAFFIC_CACHE_DB.put("TRAFFIC_CACHE_DB", allObjects);

			} else {
//				logger.info("Getting DB from cache");
				allObjects = TRAFFIC_CACHE_DB.get("TRAFFIC_CACHE_DB");
			}

		}
		//

		// Mvg
		if (req.getParameter("mvg") != null) {
			if (TRAFFIC_CACHE_MVG.get("TRAFFIC_CACHE_MVG") == null) {
				Map<String, String> params = new HashMap<String, String>();
				String STATION;
				SpiderProcessor spiderProcessor = new SpiderProcessor();
				
				// 1. HBF 
				params = new HashMap<String, String>();
				 STATION = "hauptbahnhof";
				params.put("haltestelle", STATION);
				params.put("tram", "checked");
				params.put("bus", "checked");

				spiderProcessor.setParams(params);
				spiderProcessor.setClassName(Mvg.class.getName());
				try {
					List<Object> objects = spiderProcessor.getObjects();
					for (Object object : objects) {
						Mvg mvg = (Mvg) object;
						mvg.setStation("Hauptbahnhof");
						if (mvg.getTrain() != null) {
							String firstLetter = mvg.getTrain().substring(0, 1);
							if (mvg.getTrain().equals("58")) {
								mvg.image = "http://www.mvg-live.de/MvgLive/images/size30/linie/M-58.gif";
								mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/Bus.gif";
							} else if (firstLetter.equals("N")) {
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
										+ "M-" + mvg.getTrain() + ".gif");
								mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/S-Bahn.gif";
							} else {
								mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
										+ "T-" + mvg.getTrain() + ".gif");
								mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/Tram.gif";
							}
						}
					}
					allObjects.addAll(objects);
					logger.debug("allObjects.size. "+ allObjects.size());
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				// HBF Sbahn
				params = new HashMap<String, String>();
				 STATION = "hauptbahnhof";
				params.put("haltestelle", STATION);
				params.put("sbahn", "checked");

				spiderProcessor.setParams(params);
				spiderProcessor.setClassName(Mvg.class.getName());
				try {
					List<Object> objects = spiderProcessor.getObjects();
					for (Object object : objects) {
						Mvg mvg = (Mvg) object;
						mvg.setStation("Hauptbahnhof");
						if (mvg.getTrain() != null) {
							String firstLetter = mvg.getTrain().substring(0, 1);
							if (mvg.getTrain().equals("58")) {
								mvg.image = "http://www.mvg-live.de/MvgLive/images/size30/linie/M-58.gif";
								mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/Bus.gif";
							} else if (firstLetter.equals("N")) {
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
										+ "M-" + mvg.getTrain() + ".gif");
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
		
				// HBF Ubahn
				params = new HashMap<String, String>();
				 STATION = "hauptbahnhof";
				params.put("haltestelle", STATION);
				params.put("ubahn", "checked");

				spiderProcessor.setParams(params);
				spiderProcessor.setClassName(Mvg.class.getName());
				try {
					List<Object> objects = spiderProcessor.getObjects();
					for (Object object : objects) {
						Mvg mvg = (Mvg) object;
						mvg.setStation("Hauptbahnhof");
						if (mvg.getTrain() != null) {
							String firstLetter = mvg.getTrain().substring(0, 1);
							if (mvg.getTrain().equals("58")) {
								mvg.image = "http://www.mvg-live.de/MvgLive/images/size30/linie/M-58.gif";
								mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/Bus.gif";
							} else if (firstLetter.equals("N")) {
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
										+ "M-" + mvg.getTrain() + ".gif");
								mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/S-Bahn.gif";
							} else {
								mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
										+ "T-" + mvg.getTrain() + ".gif");
								mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/Tram.gif";
							}
						}
					}
					allObjects.addAll(objects);
					logger.debug("allObjects.size. "+ allObjects.size());
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
						setImages(mvg);
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
						setImages(mvg);
					}
					allObjects.addAll(objects);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				TRAFFIC_CACHE_MVG.put("TRAFFIC_CACHE_MVG", allObjects);

			} else {
				allObjects = TRAFFIC_CACHE_MVG.get("TRAFFIC_CACHE_MVG");
			}

		}
		//

		// Airport
		if (req.getParameter("air") != null) {
			if (TRAFFIC_CACHE_AIR.get("TRAFFIC_CACHE_AIR") == null) {
				Airport airport = new Airport();
				allObjects = airport.pull(250);

//				for (Object munichAirport : allObjects) {
//					logger.info(munichAirport);
//				}

				TRAFFIC_CACHE_AIR.put("TRAFFIC_CACHE_AIR", allObjects);

			} else {
				allObjects = TRAFFIC_CACHE_AIR.get("TRAFFIC_CACHE_AIR");
			}
		}

		Collections.sort(allObjects);
//		Collections.reverse(allObjects);

		List<TrafficInfo> subList = new ArrayList<TrafficInfo>();
		
		int i = 0;

		// List<Object> obj = new ArrayList<Object>(allObjects);
		// //Format time for view
		for (Object object : allObjects) {
			TrafficInfo trafficInfo = (TrafficInfo) object;
			// if (trafficInfo.getTrain() == null
			// || trafficInfo.getTrain().trim().equals("")) {
			// continue;
			// }
			if (trafficInfo.getTime() != null) {
				// trafficInfo.timeShift = new SimpleDateFormat("m")
				// .format(new Date(trafficInfo.getTime().getTime() + 1000
				// * 60 * 60 - date.getTime()));

				trafficInfo.timeShift = String.valueOf(((trafficInfo.getTime()
						.getTime()) - date.getTime()) / (1000 * 60));

				// logger.info(trafficInfo.timeShift);
				trafficInfo.setTimeString(new SimpleDateFormat("HH:mm",
						Locale.GERMAN).format(new Date(trafficInfo.getTime()
						.getTime()
				// Somerzeit Bug?
				// + 1000 * 60 * 60
						)));
				// obj.add(trafficInfo);
				if (req.getParameter("air") != null) {
//					logger.info(trafficInfo.getTimeShift());
					if (Integer.parseInt(trafficInfo.getTimeShift()) < 40) {
						continue;
					}
				}
				// Anzahl Zeilen
				if (i < 250) {
					subList.add(trafficInfo);
					i++;
				}
			}

		}
		
		TrafficInfoDTO trafficInfoDTO = new TrafficInfoDTO();
		trafficInfoDTO.setAllObjects(subList);
		trafficInfoDTO.setTime(new SimpleDateFormat("HH:mm", Locale.GERMAN)
				.format(new Date().getTime()
				// Somerzeit Bug?
				// + 1000 * 60 * 60
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

	private void setImages(Mvg mvg) {
		if (mvg.getTrain() != null) {
			String firstLetter = mvg.getTrain().substring(0, 1);
			if (mvg.getTrain().equals("58")) {
				mvg.image = "http://www.mvg-live.de/MvgLive/images/size30/linie/M-58.gif";
				mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/Bus.gif";
			}else if (mvg.getTrain().equals("100")) {
				mvg.image = "http://www.mvg-live.de/MvgLive/images/size30/linie/S-100.gif";
				mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/Bus.gif";
			}else if (mvg.getTrain().equals("150")) {
				mvg.image = "http://www.mvg-live.de/MvgLive/images/size30/linie/S-150.gif";
				mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/Bus.gif";
			} else if (firstLetter.equals("N")) {
				mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
						+ firstLetter
						+ "-"
						+ mvg.getTrain().substring(1) + ".gif");
			} else if (firstLetter.equals("X")) {
				mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
						+ firstLetter
						+ "-"
						+ mvg.getTrain().substring(1) + ".gif");
				mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/ExpressBus.gif";
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
				mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/Bus.gif";
			}

			else {
				mvg.image = ("http://www.mvg-live.de/MvgLive/images/size30/linie/"
						+ "T-" + mvg.getTrain() + ".gif");
				mvg.imageGeneral = "http://www.mvg-live.de/MvgLive/images/size30/produkt/Tram.gif";
			}
		}
	}
}