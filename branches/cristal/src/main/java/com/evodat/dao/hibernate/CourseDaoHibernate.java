package com.evodat.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.evodat.dao.CourseDao;
import com.evodat.model.Course;

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

}
