package com.evodat.service;

import java.util.List;

import com.evodat.model.JCalendar;
import com.evodat.model.Room;

public interface JCalendarManager {

	JCalendar getRunningCalendar(String room);

	List<JCalendar> getNextCalendars(int days);

	List<Room> getRooms();

}
