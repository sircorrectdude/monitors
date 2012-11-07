package com.evodat.service;

import java.util.List;

import javax.jws.WebService;

import com.evodat.model.JCalendar;

@WebService
public interface JCalendarService {
	JCalendar getRunningCalendar(String room);

	List<JCalendar> getNextCalendars(int days);
}
