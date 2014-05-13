package com.evodat.service.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evodat.dao.CarparkDao;
import com.evodat.model.Carpark;
import com.evodat.service.CarparkManager;
import com.evodat.service.CarparkService;

@Service("carparkManager")
@WebService(serviceName = "CarparkService", endpointInterface = "com.evodat.service.CarparkService")
public class CarparkManagerImpl extends GenericManagerImpl<Carpark, Long>
		implements CarparkManager, CarparkService {

	private CarparkDao carparkDao;

	@Autowired
	public void setCarparkDao(CarparkDao carparkDao) {
		this.dao = carparkDao;
		this.carparkDao = carparkDao;
	}

}
