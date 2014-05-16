package com.evodat.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.evodat.dao.MonitorDao;
import com.evodat.model.Monitor;
import com.evodat.model.User;
import com.evodat.service.MonitorNotFoundException;

@Repository("monitorDao")
public class MonitorDaoHibernate extends GenericDaoHibernate<Monitor, Long>
		implements MonitorDao {
	/**
	 * Constructor that sets the entity to Monitor.class.
	 */
	public MonitorDaoHibernate() {
		super(Monitor.class);
	}

	public Monitor getMonitorByIpAddress(String ipAddress)
			throws MonitorNotFoundException {
		List<Monitor> monitors = getHibernateTemplate().find(
				"from Monitor where ip_address=?", ipAddress);
		// log.warn("getMonitorByIpAddress(" + ipAddress + ")");
		if (monitors == null || monitors.isEmpty()) {
			throw new MonitorNotFoundException("monitor '" + monitors
					+ "' not found...");
		} else {
			Monitor monitor = (Monitor) monitors.get(0);
			// log.debug(monitor);
			return monitor;
		}
	}

	public Monitor saveMonitor(Monitor monitor) {
		if (log.isDebugEnabled()) {
			// log.debug("monitor's id: " + monitor.getId());
		}
		getHibernateTemplate().saveOrUpdate(monitor);
		// necessary to throw a DataIntegrityViolation and catch it in
		// UserManager
		getHibernateTemplate().flush();
		return monitor;
	}

	/**
	 * @param user
	 *            the user to save
	 * @return the modified user (with a primary key set if they're new)
	 */
	@Override
	public Monitor save(Monitor monitor) {
		return this.saveMonitor(monitor);
	}

	public Monitor getMonitorByAlias(String alias)
			throws MonitorNotFoundException {
		List<Monitor> monitors = getHibernateTemplate().find(
				"from Monitor where alias=?", alias);
		// log.warn("getMonitorByAlias(" + alias + ")");
		if (monitors == null || monitors.isEmpty()) {
			throw new MonitorNotFoundException("monitor '" + monitors
					+ "' not found...");
		} else {
			Monitor monitor = (Monitor) monitors.get(0);
			// log.debug(monitor);
			return monitor;
		}
	}

	public List<Monitor> getMonitorsByUser(User currentUser) {
		List<Monitor> monitors = getHibernateTemplate().find(
				"from Monitor monitor where monitor.user=?", currentUser);
		// log.warn("getMonitorByIpAddress(" + ipAddress + ")");
		return monitors;
	}
}
