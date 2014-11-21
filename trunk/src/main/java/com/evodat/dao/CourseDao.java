package com.evodat.dao;

import java.util.List;

import com.evodat.model.Course;
import com.evodat.model.User;

public interface CourseDao extends GenericDao<Course, Long> {
	Course saveCourse(Course course);

	List<Course> getCoursesByUser(User currentUser);
}
