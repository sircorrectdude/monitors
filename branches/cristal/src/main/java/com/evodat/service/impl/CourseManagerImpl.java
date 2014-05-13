package com.evodat.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evodat.dao.CourseDao;
import com.evodat.model.Course;
import com.evodat.service.CourseManager;
import com.evodat.service.CourseService;

@Service("courseManager")
@WebService(serviceName = "CourseService", endpointInterface = "com.evodat.service.CourseService")
public class CourseManagerImpl extends GenericManagerImpl<Course, Long>
		implements CourseManager, CourseService {

	private CourseDao courseDao;

	@Autowired
	public void setTemplateDao(CourseDao courseDao) {
		this.dao = courseDao;
		this.courseDao = courseDao;
	}

	public Course getCourse(String courseId) {
		return courseDao.get(new Long(courseId));
	}

	public Course saveCourse(Course course) {
		return courseDao.saveCourse(course);
	}

	public void removeCourse(String courseId) {
		log.debug("removing course: " + courseId);
		courseDao.remove(new Long(courseId));

	}

	public List<Course> getCourses() {
		return courseDao.getAllDistinct();
	}

}
