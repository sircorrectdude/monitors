package com.evodat.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evodat.dao.LicenseDao;
import com.evodat.model.License;
import com.evodat.model.User;
import com.evodat.service.LicenseManager;
import com.evodat.service.LicenseService;

@Service("licenseManager")
@WebService(serviceName = "LicenseService", endpointInterface = "com.evodat.service.LicenseService")
public class LicenseManagerImpl extends GenericManagerImpl<License, Long>
		implements LicenseManager, LicenseService {

	private LicenseDao licenseDao;

	@Autowired
	public void setLicenseDao(LicenseDao licenseDao) {
		this.dao = licenseDao;
		this.licenseDao = licenseDao;
	}

	public List<License> getLicensesByUser(User currentUser) {
		return licenseDao.getLicensesByUser(currentUser);
	}

}
