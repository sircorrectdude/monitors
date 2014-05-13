package com.evodat.webapp.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.evodat.model.JCalendar;
import com.evodat.model.Monitor;
import com.evodat.model.Room;
import com.evodat.service.MonitorNotFoundException;
import com.evodat.webapp.model.Event;
import com.lowagie.text.RomanList;
import com.opensymphony.xwork2.Preparable;

public class RoomAction extends BaseAction implements ServletRequestAware, Preparable{

	protected HttpServletRequest servletRequest;
	private String remoteAddr;
	private String roomName;
	
	public void prepare() throws Exception {
		remoteAddr = getRequest().getRemoteAddr();
		log.debug("Request from: " + getRequest().getRemoteAddr() + " Method: "
				+ getRequest().getMethod());

	}
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public Event getRunningEvent() {
		// Auto Resolv  Alias = roomname 
		Monitor monitorByIpAddress;
		try {
			monitorByIpAddress = monitorManager.getMonitorByIpAddress(remoteAddr);
			setRoomName(monitorByIpAddress.getAlias().toUpperCase());
			log.debug("roomName: " + roomName);
		} catch (MonitorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// end
		
		List<JCalendar> nextCalendars = jCalendarManager.getNextCalendars(1);
		Calendar now = Calendar.getInstance();
		Date nowDate = now.getTime();
		Event event = new Event();
		event.setRoomName(roomName);
		for (JCalendar jCalendar : nextCalendars) {
			Calendar startTime = Calendar.getInstance();
			startTime.setTime(jCalendar.getStartTime());
			startTime.add(Calendar.HOUR_OF_DAY,-4);
			Date startDate = startTime.getTime();
			Calendar endTime = Calendar.getInstance();
			endTime.setTime(jCalendar.getEndTime());
			endTime.add(Calendar.HOUR_OF_DAY,0);
			Date endDate = endTime.getTime();
			boolean display = (jCalendar.getColor().getName().equals(roomName)
					|| (jCalendar.getColor().getId().equals(Room.RUBIN_1_2) && (roomName
							.equals("RUBIN I") || roomName.equals("RUBIN II"))) || (jCalendar
					.getColor().getId().equals(Room.CARAT_JUWEL) && (roomName
					.equals("CARAT") || roomName.equals("JUWEL"))))
					&& (startDate.before(nowDate) && endDate.after(nowDate));
			
			if (display) {
				
				event.setDateString(new SimpleDateFormat("dd. MMMMM yyyy")
						.format(jCalendar.getStartTime()));
				event.setStartString(new SimpleDateFormat("H.mm")
						.format(jCalendar.getStartTime()));
				event.setEndString(new SimpleDateFormat("H.mm 'UHR'")
						.format(jCalendar.getEndTime()));
				event.setTimeString(event.getStartString() + " - "
						+ event.getEndString());
				event.setLogo(jCalendar.getDescription());
				event.setRoomLocation(jCalendar.getLocation());
				event.setCompany(jCalendar.getSubject());
				log.info(event);
			}
		}
		return event;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

}
