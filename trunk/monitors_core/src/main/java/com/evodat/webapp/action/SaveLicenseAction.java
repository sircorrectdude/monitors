package com.evodat.webapp.action;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.evodat.model.License;

public class SaveLicenseAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2085794607110789719L;

	@Override
	public String execute() throws Exception {
		Date now = new Date();
		License license = new License();
		license.setUser(getCurrentUser());
		license.setUuid(UUID.randomUUID().toString());
		license.setCreated(now);
		license.setValidFrom(now);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.MONTH, 1);
		license.setValidTo(calendar.getTime());
		licenseManager.save(license);
		return SUCCESS;
	}
}
