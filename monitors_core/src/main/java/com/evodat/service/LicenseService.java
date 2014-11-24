package com.evodat.service;

import java.util.List;

import javax.jws.WebService;

import com.evodat.model.License;
import com.evodat.model.User;

@WebService
public interface LicenseService {
	List<License> getLicensesByUser(User currentUser);
}
