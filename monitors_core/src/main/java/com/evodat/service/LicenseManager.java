package com.evodat.service;

import java.util.List;

import com.evodat.model.License;
import com.evodat.model.User;

public interface LicenseManager extends GenericManager<License, Long> {
	List<License> getLicensesByUser(User currentUser);
}
