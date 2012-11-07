package com.evodat.service;

import java.util.List;

import javax.jws.WebService;

import com.evodat.model.Course;

@WebService
public interface CourseService {
	Course getCourse(String courseId);

	Course saveCourse(Course course);

	void removeCourse(String courseId);

	List<Course> getCourses();
}
