package com.evodat.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import com.evodat.dao.MonitorDao;
import com.evodat.model.Monitor;
import com.evodat.model.User;
import com.evodat.service.MonitorExistsException;
import com.evodat.service.MonitorManager;
import com.evodat.service.MonitorNotFoundException;
import com.evodat.service.MonitorService;

@Service("monitorManager")
@WebService(serviceName = "MonitorService", endpointInterface = "com.evodat.service.MonitorService")
public class MonitorManagerImpl extends GenericManagerImpl<Monitor, Long>
		implements MonitorManager, MonitorService {

	private MonitorDao monitorDao;

	@Autowired
	public void setMonitorDao(MonitorDao monitorDao) {
		this.dao = monitorDao;
		this.monitorDao = monitorDao;
	}

	public Monitor getMonitor(String monitorId) {
		return monitorDao.get(new Long(monitorId));
	}

	public Monitor getMonitorByIpAddress(String ipAddress)
			throws MonitorNotFoundException {
		return monitorDao.getMonitorByIpAddress(ipAddress);
	}

	public List<Monitor> getMonitors() {
		return monitorDao.getAllDistinct();
	}

	public void removeMonitor(String monitorId) {
		log.debug("removing monitor: " + monitorId);
		monitorDao.remove(new Long(monitorId));

	}

	public Monitor saveMonitor(Monitor monitor) throws MonitorExistsException {
		try {
			return monitorDao.saveMonitor(monitor);
		} catch (DataIntegrityViolationException e) {
			// e.printStackTrace();
			log.warn(e.getMessage());
			throw new MonitorExistsException("Monitor '"
					+ monitor.getIpAddress() + "' already exists!");
		} catch (JpaSystemException e) { // needed for JPA
			// e.printStackTrace();
			log.warn(e.getMessage());
			throw new MonitorExistsException("Monitor '"
					+ monitor.getIpAddress() + "' already exists!");
		}
	}

	public Monitor getMonitorByAlias(String alias)
			throws MonitorNotFoundException {
		return monitorDao.getMonitorByAlias(alias);
	}

	public List<Monitor> getMonitorsByUser(User currentUser) {
		return monitorDao.getMonitorsByUser(currentUser);
	}

	public Monitor getMonitorByUuid(String uuid)
			throws MonitorNotFoundException {
		return monitorDao.getMonitorByUuid(uuid);
	}

}
