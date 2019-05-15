package com.evodat.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evodat.dao.JCalendarDao;
import com.evodat.model.JCalendar;
import com.evodat.model.Room;
import com.evodat.service.JCalendarManager;
import com.evodat.service.JCalendarService;

@Service("jCalendarManager")
@WebService(serviceName = "JCalendarService", endpointInterface = "com.evodat.service.JCalendarService")
public class JCalendarManagerImpl extends GenericManagerImpl<JCalendar, Long>
		implements JCalendarManager, JCalendarService {

	private JCalendarDao jCalendarDao;

	@Autowired
	public void setJCalendarDao(JCalendarDao jCalendarDao) {
		this.dao = jCalendarDao;
		this.jCalendarDao = jCalendarDao;
	}

	public JCalendar getRunningCalendar(Room room) {
		return jCalendarDao.getRunningCalendar(room);
	}

	public List<JCalendar> getNextCalendars(int days) {
		return jCalendarDao.getNextCalendars(days);
	}

	public List<Room> getRooms() {
		return jCalendarDao.getRooms();
	}

}
