package com.evodat.webapp.action;

import java.util.ArrayList;
import java.util.List;

import com.evodat.model.Course;
import com.evodat.model.Screen;
import com.evodat.model.Template;

public class ScreenAction extends BaseAction {

	private static final long serialVersionUID = -24977687713985199L;

	private List<Template> templates;

	private List<Screen> screens;

	private Screen screen;

	private String courseId;
	private String screenId;
	private Course course;

	@Override
	public String execute() throws Exception {
		templates = templateManager.getTemplates(getCurrentUser());
		return SUCCESS;
	}

	public String save() throws Exception {

		course = courseManager.getCourse(courseId);
		screen.setCourse(course);
		screenManager.saveScreen(screen);

		// add success messages
		List<Object> args = new ArrayList<Object>();
		args.add(screen.getCronExpression());
		saveMessage(getText("screen.added", args));
		// Send an account information e-mail
		return SUCCESS;
	}

	public String delete() {
		screen = screenManager.getScreen(screenId);
		course = screen.getCourse();
		course.getScreens().remove(screen);
		courseManager.save(course);
		log.info(course);
		// course = courseManager.getCourse(String.valueOf(course.getId()));
		screenManager.removeScreen(screenId);
		List<Object> args = new ArrayList<Object>();
		// args.add(screen.getCronExpression());
		saveMessage(getText("screen.deleted", args));
		setCourseId(String.valueOf(course.getId()));
		return SUCCESS;
	}

	public void setTemplates(List<Template> templates) {
		this.templates = templates;
	}

	public List<Template> getTemplates() {
		return templates;
	}

	public List<Screen> getScreens() {
		return screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
