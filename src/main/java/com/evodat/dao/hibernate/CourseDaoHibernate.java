package com.evodat.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.evodat.dao.CourseDao;
import com.evodat.model.Course;
import com.evodat.model.User;

@Repository("courseDao")
public class CourseDaoHibernate extends GenericDaoHibernate<Course, Long>
		implements CourseDao {

	public CourseDaoHibernate() {
		super(Course.class);
	}

	public Course saveCourse(Course course) {
		if (log.isDebugEnabled()) {
			log.debug("course id: " + course.getId());
		}
		getHibernateTemplate().saveOrUpdate(course);
		getHibernateTemplate().flush();
		return course;
	}

	@Override
	public Course save(Course course) {
		return this.saveCourse(course);
	}

	public List<Course> getCoursesByUser(User currentUser) {
		List<Course> courses = getHibernateTemplate().find(
				"from Course course where course.user=?", currentUser);
		// log.warn("getMonitorByIpAddress(" + ipAddress + ")");
		return courses;
	}

}
