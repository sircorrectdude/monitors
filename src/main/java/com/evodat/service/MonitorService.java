package com.evodat.service;

import java.util.List;

import javax.jws.WebService;

import com.evodat.model.Monitor;

@WebService
public interface MonitorService {

	Monitor getMonitor(String monitorId);

	Monitor getMonitorByIpAddress(String ipAddress)
			throws MonitorNotFoundException;

	Monitor saveMonitor(Monitor user) throws MonitorExistsException;

	void removeMonitor(String monitorId);

	List<Monitor> getMonitors();

}
