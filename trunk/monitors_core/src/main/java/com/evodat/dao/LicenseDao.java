package com.evodat.dao;

import java.util.List;

import com.evodat.model.License;
import com.evodat.model.User;

public interface LicenseDao extends GenericDao<License, Long> {

	List<License> getLicensesByUser(User currentUser);

}
