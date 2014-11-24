package com.evodat.service;

import java.util.List;

import com.evodat.model.Course;
import com.evodat.model.User;

public interface CourseManager extends GenericManager<Course, Long> {
	Course getCourse(String courseId);

	Course saveCourse(Course course);

	void removeCourse(String courseId);

	List<Course> getCourses();

	List<Course> getCoursesByUser(User currentUser);
}
