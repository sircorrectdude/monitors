package com.evodat.dao;

import com.evodat.model.Course;

public interface CourseDao extends GenericDao<Course, Long> {
	Course saveCourse(Course course);
}
