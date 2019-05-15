package com.evodat.service;

import java.util.List;

import javax.jws.WebService;

import com.evodat.model.JCalendar;
import com.evodat.model.Room;

@WebService
public interface JCalendarService {
	JCalendar getRunningCalendar(Room room);

	List<JCalendar> getNextCalendars(int days);
}
