package com.evodat.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.evodat.dao.JCalendarDao;
import com.evodat.model.JCalendar;
import com.evodat.model.Room;

@Repository("jCalendarDao")
public class JCalendarDaoHibernate extends GenericDaoHibernate<JCalendar, Long>
		implements JCalendarDao {

	public JCalendarDaoHibernate() {
		super(JCalendar.class);
	}

	public JCalendar getRunningCalendar(String room) {
		return null;
	}

	public List<JCalendar> getNextCalendars(int days) {
		List<JCalendar> calendars = getHibernateTemplate().find(
				"from JCalendar jc order by jc.startTime");
		return calendars;
	}

	public List<Room> getRooms() {
		List<Room> rooms = getHibernateTemplate()
				.find("from Room room where room.id not like '-1' and room.id not like '7' and room.id not like '4'");
		return rooms;
	}

}
