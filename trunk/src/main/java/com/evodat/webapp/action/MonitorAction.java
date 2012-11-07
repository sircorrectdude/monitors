package com.evodat.webapp.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.evodat.model.Monitor;
import com.opensymphony.xwork2.Preparable;

public class MonitorAction extends BaseAction implements Preparable {
	private static final long serialVersionUID = 1219079371677051761L;

	private List monitors;
	private Monitor monitor;
	private String id;
	private List courses;

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
	 * Sends users to "mainMenu" when !from.equals("list"). Sends everyone else to "cancel"
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
		monitors = monitorManager.getMonitors();
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

		monitorManager.saveMonitor(monitor);

		if (!"list".equals(from)) {
			// add success messages
			saveMessage(getText("monitor.saved"));
			return "mainMenu";
		} else {
			// add success messages
			List<Object> args = new ArrayList<Object>();
			args.add(monitor.getIpAddress());
			saveMessage(getText("monitor.added", args));
			// Send an account information e-mail
			return SUCCESS;
		}
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

	public List getMonitors() {
		return monitors;
	}

	public void setMonitors(List monitors) {
		this.monitors = monitors;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public List getCourses() {
		return courses;
	}

	public void setCourses(List courses) {
		this.courses = courses;
	}

	public void setId(String id) {
		this.id = id;
	}
}
