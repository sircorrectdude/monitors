package com.evodat.webapp.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.evodat.model.JCalendar;
import com.evodat.model.Room;
import com.evodat.webapp.model.Event;

public class JCalendarAction extends BaseAction {

	private static final long serialVersionUID = -7452676759019058826L;

	List<JCalendar> calendars;
	private String rooms = "";
	private List<Room> emptyRooms = new ArrayList<Room>();

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public List<Event> getCalendars() {
		List<JCalendar> nextCalendars = jCalendarManager.getNextCalendars(1);
		List<Room> rooms = jCalendarManager.getRooms();

		if (nextCalendars == null || nextCalendars.isEmpty()) {
			return null;
		}

		List<Event> events = new ArrayList<Event>();

		long now = new Date().getTime() + 1000 * 60 * 60;

		// Anzeigezeitraum vor/nach erster Tagung
		long before = 1000 * 60 * 60 * 3;
		long after = 1000 * 60 * 60 * 1;

		long firstEventTime = now;
		long lastEventTime = 0;
		for (JCalendar jCalendar : nextCalendars) {
			Calendar nowC = Calendar.getInstance();
			nowC.setTimeInMillis(now);
			Calendar startTime = Calendar.getInstance();
			Calendar endTime = Calendar.getInstance();
			startTime.setTime(jCalendar.getStartTime());
			endTime.setTime(jCalendar.getEndTime());
			if ((startTime.get(Calendar.YEAR) == nowC.get(Calendar.YEAR)
					&& startTime.get(Calendar.MONTH) == nowC
							.get(Calendar.MONTH) && startTime
						.get(Calendar.DAY_OF_MONTH) == nowC
					.get(Calendar.DAY_OF_MONTH))) {
				if (jCalendar.getStartTime().getTime() < firstEventTime)
					firstEventTime = jCalendar.getStartTime().getTime();
				if (jCalendar.getEndTime().getTime() > lastEventTime)
					lastEventTime = jCalendar.getEndTime().getTime();

			}

		}

		Calendar nowC = Calendar.getInstance();
		nowC.setTimeInMillis(now);

		for (JCalendar jCalendar : nextCalendars) {
			Calendar startTime = Calendar.getInstance();
			Calendar endTime = Calendar.getInstance();
			startTime.setTime(jCalendar.getStartTime());
			endTime.setTime(jCalendar.getEndTime());
			if ((firstEventTime - before < now && lastEventTime + after > now)
					&& (startTime.get(Calendar.YEAR) == nowC.get(Calendar.YEAR)
							&& startTime.get(Calendar.MONTH) == nowC
									.get(Calendar.MONTH) && startTime
							.get(Calendar.DAY_OF_MONTH) == nowC
							.get(Calendar.DAY_OF_MONTH))) {
				if (jCalendar.getColor().getId().equals(Room.RUBIN_1_2)) {

					Room room = new Room();
					room.setName("RUBIN I");
					room.setId(Room.RUBIN_1);
					room.setLocation("DOLOMIT");
					jCalendar.setColor(room);
					addEvent(events, jCalendar);

					room.setName("RUBIN II");
					room.setId(Room.RUBIN_2);
					jCalendar.setColor(room);
					addEvent(events, jCalendar);

				} else if (jCalendar.getColor().getId()
						.equals(Room.CARAT_JUWEL)
						&& !getRooms().equals(Room.RUBIN_1_2)) {

					Room room = new Room();
					room.setName("CARAT");
					room.setId(Room.CARAT);
					room.setLocation("7. OG");
					jCalendar.setColor(room);
					addEvent(events, jCalendar);

					room.setName("JUWEL");
					room.setId(Room.JUWEL);
					jCalendar.setColor(room);
					addEvent(events, jCalendar);

				}

				else {
					// RoomParameter for Dolomit
					if (!getRooms().equals(Room.RUBIN_1_2)) {
						addEvent(events, jCalendar);
					} else {
						if (jCalendar.getColor().getId().equals(Room.RUBIN_1)
								|| jCalendar.getColor().getId()
										.equals(Room.RUBIN_2)) {
							addEvent(events, jCalendar);
						}
					}
				}
			}
		}

		for (Room room : rooms) {
			boolean isEmpty = true;
			for (Event event : events) {
				if (room.getId().equals(event.getRoomId())) {
					isEmpty = false;
				}
			}
			if (isEmpty) {
				emptyRooms.add(room);
			}
		}

		return events;
	}

	private void addEvent(List<Event> events, JCalendar jCalendar) {
		Event event = new Event();
		event.setDateString(new SimpleDateFormat("dd. MMMMM yyyy")
				.format(jCalendar.getStartTime()));
		event.setDateStringEn(new SimpleDateFormat("MMMMM, dd'th' yyyy",
				Locale.ENGLISH).format(jCalendar.getStartTime()));
		event.setStartString(new SimpleDateFormat("H.mm").format(jCalendar
				.getStartTime()));
		event.setStartStringEn(new SimpleDateFormat("h:mm a", Locale.ENGLISH)
				.format(jCalendar.getStartTime()));
		event.setEndString(new SimpleDateFormat("H.mm").format(jCalendar
				.getEndTime()));
		event.setLogo(jCalendar.getDescription());
		if (jCalendar.getColor() != null) {
			event.setRoomLocation(jCalendar.getColor().getLocation());
			event.setRoomName(jCalendar.getColor().getName());
		}
		event.setCompany(jCalendar.getSubject());
		event.setRoomId(jCalendar.getColor().getId());
		events.add(event);
		// log.info(event);
	}

	public String getToday() {
		return "VERANSTALTUNGEN "
				+ new SimpleDateFormat("EEEE, dd.MM.yyyy").format(new Date());
	}

	public String getToday_en() {
		return "EVENTS "
				+ new SimpleDateFormat("EEEE, dd.MM.yyyy", Locale.ENGLISH)
						.format(new Date());
	}

	public String getRooms() {
		return rooms;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}

	public List<Room> getEmptyRooms() {
		return emptyRooms;
	}

	public void setEmptyRooms(List<Room> emptyRooms) {
		this.emptyRooms = emptyRooms;
	}

}
