package com.evodat.webapp.action;

import java.io.IOException;
import java.util.UUID;

import com.evodat.model.Course;
import com.evodat.model.CourseMode;
import com.evodat.model.Monitor;
import com.evodat.model.Screen;
import com.evodat.model.Template;
import com.evodat.model.TemplateType;

public class QuickstartAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 279309491889142645L;

	protected Template template;
	private String id;
	protected TemplateType templateType;
	private Monitor monitor;

	public String edit() throws IOException {

		if (id != null) {
			template = templateManager.getTemplate(id);
		} else {
			template = new Template();
			template.setTemplateType(templateType);
		}

		return SUCCESS;
	}

	public String save() {
		template = templateManager
				.getTemplate(String.valueOf(template.getId()));
		Course course = new Course();
		course.setUser(getCurrentUser());
		course.setName(getCurrentUser().getUsername() + "_" + UUID.randomUUID());
		course.setCourseMode(CourseMode.SINGLE);
		course = courseManager.save(course);
		Screen screen = new Screen();
		screen.setCourse(course);
		screen.setTemplate(template);
		screenManager.save(screen);
		monitor.setCourse(course);
		monitor.setUser(getCurrentUser());
		monitorManager.save(monitor);

		return SUCCESS;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TemplateType getTemplateType() {
		return templateType;
	}

	public void setTemplateType(TemplateType templateType) {
		this.templateType = templateType;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

}
