package com.evodat.service.impl;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evodat.dao.LicensePlateDao;
import com.evodat.model.LicensePlate;
import com.evodat.service.LicensePlateManager;
import com.evodat.service.LicensePlateService;

@Service("licensePlateManager")
@WebService(serviceName = "LicensePlateService", endpointInterface = "com.evodat.service.LicensePlateService")
public class LicensePlateManagerImpl extends GenericManagerImpl<LicensePlate, Long>
		implements LicensePlateManager, LicensePlateService {

	private LicensePlateDao licensePlateDao;

	@Autowired
	public void setLicensePlateDao(LicensePlateDao licensePlateDao) {
		this.dao = licensePlateDao;
		this.licensePlateDao = licensePlateDao;
	}

	public List<LicensePlate> getAllByDates(Date startDate, Date endDate) {
		return licensePlateDao.getAllByDates(startDate, endDate);
	}

}
