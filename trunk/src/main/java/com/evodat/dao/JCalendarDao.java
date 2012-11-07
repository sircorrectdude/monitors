package com.evodat.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.evodat.model.JCalendar;
import com.evodat.model.Room;

public interface JCalendarDao extends GenericDao<JCalendar, Long> {

	@Transactional
	JCalendar getRunningCalendar(String room);

	@Transactional
	List<JCalendar> getNextCalendars(int days);

	@Transactional
	List<Room> getRooms();

}
