package com.evodat.webapp.action;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.SimpleTriggerContext;

import com.evodat.model.CourseMode;
import com.evodat.model.Monitor;
import com.evodat.model.Screen;
import com.evodat.model.Template;
import com.evodat.service.MonitorNotFoundException;
import com.opensymphony.xwork2.Preparable;

public class ClientMonitorAction extends BaseAction implements Preparable,
		ServletResponseAware, ServletRequestAware {

	private static final long serialVersionUID = 2591031598410000233L;

	public static final int DEFAULT_REFRESH = 30;
	// Screen Options
	public String backgroundColor = "transparent";

	private String remoteAddr;
	private String content;
	private String refresh = String.valueOf(DEFAULT_REFRESH);
	private String aliasPath;
	private String fade = "0";
	private boolean removeBody = true;

	// For access to the raw servlet request / response, eg for cookies
	protected HttpServletRequest servletRequest;
	protected HttpServletResponse servletResponse;

	public void prepare() throws Exception {
		// Enumeration attrNames = getRequest().getAttributeNames();
		// while (attrNames.hasMoreElements()) {
		// Object nextElement = attrNames.nextElement();
		// log.info(nextElement);
		// log.info(getRequest().getAttribute(nextElement.toString()));
		// }
		// Enumeration headerNames = getRequest().getHeaderNames();
		// while (headerNames.hasMoreElements()) {
		// Object nextElement = headerNames.nextElement();
		// log.info(nextElement);
		// log.info(getRequest().getHeader(nextElement.toString()));
		// }
		remoteAddr = getRequest().getRemoteAddr();
		log.debug("Request from: " + getRequest().getRemoteAddr() + " Method: "
				+ getRequest().getMethod());
		aliasPath = getRequest().getParameter("alias");
		 if (null != aliasPath) {
		 	log.debug("Request from: " +"Alias: " + aliasPath);
		 }

	}


	public String execute() {

		if (getRequest().getMethod().equals("HEAD")) {
			return null;
		}
		Cookie lastPageUpdateCookie = new Cookie("lastPageUpdateCookie", "");
		lastPageUpdateCookie.setPath("/");
		Cookie lastScreenIdCookie = new Cookie("lastScreenIdCookie", "");
		lastScreenIdCookie.setPath("/");
		Cookie[] cookies = servletRequest.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("lastPageUpdateCookie")) {
					lastPageUpdateCookie = c;
				}
				if (c.getName().equals("lastScreenIdCookie")) {
					lastScreenIdCookie = c;
				}
			}
		}
		Monitor monitor = null;
		try {
			if (aliasPath != null) {
				monitor = monitorManager.getMonitorByAlias(aliasPath);
			} else {
				monitor = monitorManager.getMonitorByIpAddress(remoteAddr);
			}
			// TODO
			CourseMode courseMode = monitor.getCourse().getCourseMode();
			List<Screen> screens = monitor.getCourse().getScreens();
			Screen defaultScreen = new Screen();
			Template defaultTemplate = new Template();
			defaultTemplate.setText("");
			defaultScreen.setId(-1l);
			defaultScreen.setTemplate(defaultTemplate);
			defaultScreen.setDuration(DEFAULT_REFRESH);
			Screen screenToSet = defaultScreen;

			if (courseMode == CourseMode.SINGLE) {
				if (screens.size() != 0) {
					screenToSet = screens.get(screens.size() - 1);
					if (screenToSet.getDuration() == null
							|| screenToSet.getDuration() <= 0) {
						screenToSet.setDuration(DEFAULT_REFRESH);
					}

				}
			} else if (courseMode == CourseMode.CYCLE) {
				removeBody = false;
				fade = "1000";
				screenToSet = screens.get(0);
				screenToSet.setDuration(DEFAULT_REFRESH);
				boolean nextScreen = false;
//				log.info(screens.size() + " Screens");
				for (Screen screen : screens) {
					// log.info("iD Screen" + screen.getId());
					// log.info("Duration Screen" + screen.getDuration());
					if (nextScreen) {
						screenToSet = screen;
						if (screenToSet.getDuration() == null
								|| screenToSet.getDuration() <= 0) {
							screenToSet.setDuration(DEFAULT_REFRESH);
						}
						break;
					} else if (String.valueOf(screen.getId()).equals(
							lastScreenIdCookie.getValue())) {
//						log.info("use next Screen (this:" + screen.getId()
//								+ ")");
						nextScreen = true;
					}
				}

			} else if (courseMode == CourseMode.DATETIME) {

				for (Screen screen : screens) {
					if (String.valueOf(screen.getId()).equals(
							lastScreenIdCookie.getValue())) {
						screenToSet = screen;
						if (screenToSet.getDuration() == null
								|| screenToSet.getDuration() <= 0) {
							screenToSet.setDuration(DEFAULT_REFRESH);
						}
					}
					String cronExpression = screen.getCronExpression();
					CronTrigger trigger = new CronTrigger(cronExpression);
					SimpleTriggerContext context = new SimpleTriggerContext();
					Date executionTime = trigger.nextExecutionTime(context);
					// String monthOfExecution = DateFormatUtils.format(
					// executionTime, "hh:mm:ss dd-MM-yyyy");
					// log.info(monthOfExecution);
					Date now = new Date();
					// Date timeDelta = new Date(now.getTime()
					// - Long.valueOf(lastPageUpdate));
					// log.info("timeDelta:" + timeDelta);
					Date realTime = new Date(now.getTime()
							+ screenToSet.getDuration() * 1000);
					log.info(realTime);
					log.info("executionTime:" + executionTime);
					if (new Date(executionTime.getTime()).before(realTime)) {
						log.info(realTime.getTime() - executionTime.getTime());
						screenToSet = screen;
						if (screenToSet.getDuration() == null
								|| screenToSet.getDuration() <= 0) {
							screenToSet.setDuration(DEFAULT_REFRESH);
						}
						break;
					}
				}
			}
			setContent(screenToSet.getTemplate().getText());

			// Save to cookie
			lastScreenIdCookie.setValue(String.valueOf(screenToSet.getId()));
			lastScreenIdCookie.setPath("/");
			lastPageUpdateCookie.setValue(String.valueOf(new Date().getTime()));
			lastScreenIdCookie.setPath("/");
			servletResponse.addCookie(lastScreenIdCookie);
			lastScreenIdCookie.setMaxAge(0);
			lastPageUpdateCookie.setMaxAge(0);
			servletResponse.addCookie(lastPageUpdateCookie);
			setRefresh(String.valueOf(screenToSet.getDuration()));

			// log.debug("Monitor: " + monitor.getTemplate().getText());
		} catch (MonitorNotFoundException e) {
			// e.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getRefresh() {
		return refresh;
	}

	public void setRefresh(String refresh) {
		this.refresh = refresh;
	}

	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public String getFade() {
		return fade;
	}

	public void setFade(String fade) {
		this.fade = fade;
	}

	public boolean isRemoveBody() {
		return removeBody;
	}

	public void setRemoveBody(boolean removeBody) {
		this.removeBody = removeBody;
	}
	
	
}
