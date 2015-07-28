package com.evodat.webapp.action;

import java.util.UUID;

import com.evodat.model.Course;
import com.evodat.model.CourseMode;
import com.evodat.model.License;
import com.evodat.model.Monitor;
import com.evodat.model.Screen;
import com.evodat.model.Template;

public class SaveQuickstartAction extends BaseAction {

	private static final long serialVersionUID = -1582615140124359001L;
	private Template template;
	private Monitor monitor;
	private License license;

	public String execute() {
		log.info("calling save Quickstart... with LicenseID:" +license.getId() );
		
		license = licenseManager.get(license.getId());
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
		monitor.setLicense(license);
		monitorManager.save(monitor);
		license.setMonitor(monitor);
		licenseManager.save(license);

		return SUCCESS;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}

}
