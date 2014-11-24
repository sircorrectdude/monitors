package com.evodat.webapp.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.InterceptorRef;

import com.evodat.model.Course;
import com.evodat.model.Monitor;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.CustomValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@InterceptorRef("jsonValidationWorkflowStack")
@Validations(customValidators = { @CustomValidator(fieldName = "monitor.alias", key = "error.monitor.alias.notunique", type = "monitorAliasUniqueValidator") }, requiredStrings = {
		@RequiredStringValidator(fieldName = "monitor.ipAddress", type = ValidatorType.FIELD, key = "error.monitor.ipAddress.required"),
		@RequiredStringValidator(fieldName = "monitor.alias", type = ValidatorType.FIELD, key = "error.monitor.alias.required") })
public class MonitorAction extends BaseAction implements Preparable {
	private static final long serialVersionUID = 1219079371677051761L;

	private List<Monitor> monitors;
	private Monitor monitor;
	private String id;
	private List<Course> courses;

	public void prepare() throws Exception {
		courses = courseManager.getAll();
		if (getRequest().getMethod().equalsIgnoreCase("post")
				&& (!"".equals(getRequest().getParameter("monitor.id")))) {
			monitor = monitorManager.getMonitor(getRequest().getParameter(
					"monitor.id"));

		}

	}

	/**
	 * Default: just returns "success"
	 * 
	 * @return "success"
	 */
	public String execute() {
		return SUCCESS;
	}

	/**
	 * Sends users to "mainMenu" when !from.equals("list"). Sends everyone else
	 * to "cancel"
	 * 
	 * @return "mainMenu" or "cancel"
	 */
	public String cancel() {
		if (!"list".equals(from)) {
			return "mainMenu";
		}
		return "cancel";
	}

	public String list() {
		monitors = monitorManager.getMonitorsByUser(getCurrentUser());
		return SUCCESS;
	}

	public String edit() throws IOException {

		if (id != null) {
			monitor = monitorManager.getMonitor(id);
		} else {
			monitor = new Monitor();
		}

		return SUCCESS;
	}

	public String save() throws Exception {

		monitor.setUser(getCurrentUser());
		monitorManager.saveMonitor(monitor);

		// add success messages
		List<Object> args = new ArrayList<Object>();
		args.add(monitor.getIpAddress());
		saveMessage(getText("monitor.added", args));
		return SUCCESS;
	}

	/**
	 * Delete the user passed in.
	 * 
	 * @return success
	 */
	public String delete() {
		monitorManager.removeMonitor(monitor.getId().toString());
		List<Object> args = new ArrayList<Object>();
		args.add(monitor.getIpAddress());
		saveMessage(getText("monitor.deleted", args));

		return SUCCESS;
	}

	public List<Monitor> getMonitors() {
		return monitors;
	}

	public void setMonitors(List<Monitor> monitors) {
		this.monitors = monitors;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public void setId(String id) {
		this.id = id;
	}
}
