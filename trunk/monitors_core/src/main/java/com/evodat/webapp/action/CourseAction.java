package com.evodat.webapp.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.InterceptorRef;

import com.evodat.model.Course;
import com.evodat.model.CourseMode;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@InterceptorRef("jsonValidationWorkflowStack")
@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "course.name", type = ValidatorType.FIELD, key = "error.course.name.required") })
public class CourseAction extends BaseAction implements Preparable {

	private static final long serialVersionUID = -5752286128277850761L;
	private static final CourseMode[] courseModes = CourseMode.values();

	private Course course;
	private String id;

	private List<Course> courses;

	// private List<Screen> screens;

	public void prepare() throws Exception {
		// screens = screenManager.getAll();
		if (getRequest().getMethod().equalsIgnoreCase("post")
				&& (!"".equals(getRequest().getParameter("course.id")))) {
			course = courseManager.getCourse(getRequest().getParameter(
					"course.id"));
		}
	}

	public String list() {
		courses = courseManager.getCoursesByUser(getCurrentUser());
		return SUCCESS;
	}

	public String edit() throws IOException {

		if (id != null) {
			course = courseManager.getCourse(id);
		} else {
			course = new Course();
		}

		return SUCCESS;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String cancel() {
		if (!"list".equals(from)) {
			return "mainMenu";
		}
		return "cancel";
	}

	public String save() throws Exception {

		course.setUser(getCurrentUser());
		Course saveCourse = courseManager.saveCourse(course);
		setId(String.valueOf(saveCourse.getId()));
		// add success messages
		List<Object> args = new ArrayList<Object>();
		args.add(course.getName());
		saveMessage(getText("course.added", args));
		// Send an account information e-mail
		return SUCCESS;
	}

	public String delete() {
		courseManager.removeCourse(course.getId().toString());
		List<Object> args = new ArrayList<Object>();
		args.add(course.getName());
		saveMessage(getText("course.deleted", args));

		return SUCCESS;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	// public List<Screen> getScreens() {
	// return screens;
	// }
	//
	// public void setScreens(List<Screen> screens) {
	// this.screens = screens;
	// }

	public CourseMode[] getCoursemodes() {
		return courseModes;
	}

}
