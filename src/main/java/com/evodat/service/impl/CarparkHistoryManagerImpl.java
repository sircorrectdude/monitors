package com.evodat.service.impl;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evodat.dao.CarparkHistoryDao;
import com.evodat.model.CarparkHistory;
import com.evodat.service.CarparkHistoryManager;
import com.evodat.service.CarparkHistoryService;

@Service("carparkHistoryManager")
@WebService(serviceName = "CarparkHistoryService", endpointInterface = "com.evodat.service.CarparkHistoryService")
public class CarparkHistoryManagerImpl extends
		GenericManagerImpl<CarparkHistory, Long> implements
		CarparkHistoryManager, CarparkHistoryService {

	private CarparkHistoryDao carparkHistoryDao;

	@Autowired
	public void setCarparkHistoryDao(CarparkHistoryDao carparkHistoryDao) {
		this.dao = carparkHistoryDao;
		this.carparkHistoryDao = carparkHistoryDao;
	}

	public List<CarparkHistory> getAllByDates(Date startDate, Date endDate) {
		return carparkHistoryDao.getAllByDates(startDate, endDate);
	}

}
