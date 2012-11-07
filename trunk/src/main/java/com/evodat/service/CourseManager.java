package com.evodat.service;

import java.util.List;

import com.evodat.model.Course;

public interface CourseManager extends GenericManager<Course, Long> {
	Course getCourse(String courseId);

	Course saveCourse(Course course);

	void removeCourse(String courseId);

	List<Course> getCourses();
}
