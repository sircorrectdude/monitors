package com.evodat.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.evodat.model.Monitor;
import com.evodat.model.User;
import com.evodat.service.MonitorNotFoundException;

public interface MonitorDao extends GenericDao<Monitor, Long> {

	@Transactional
	Monitor getMonitorByIpAddress(String ipAddress)
			throws MonitorNotFoundException;

	Monitor saveMonitor(Monitor monitor);

	Monitor getMonitorByAlias(String alias) throws MonitorNotFoundException;

	List<Monitor> getMonitorsByUser(User currentUser);
}
