package com.evodat.service;

import java.util.List;

import com.evodat.model.Monitor;

public interface MonitorManager extends GenericManager<Monitor, Long> {
	Monitor getMonitor(String monitorId);

	Monitor getMonitorByIpAddress(String ipAddress)
			throws MonitorNotFoundException;

	Monitor saveMonitor(Monitor user) throws MonitorExistsException;

	void removeMonitor(String monitorId);

	List<Monitor> getMonitors();

	Monitor getMonitorByAlias(String aliasPath) throws MonitorNotFoundException;
}