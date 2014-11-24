package com.evodat.service.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evodat.dao.FloorDao;
import com.evodat.model.Floor;
import com.evodat.service.FloorManager;
import com.evodat.service.FloorService;

@Service("floorManager")
@WebService(serviceName = "FloorService", endpointInterface = "com.evodat.service.FloorService")
public class FloorManagerImpl extends GenericManagerImpl<Floor, Long> implements
		FloorManager, FloorService {

	private FloorDao floorDao;

	@Autowired
	public void setFloorDao(FloorDao floorDao) {
		this.dao = floorDao;
		this.floorDao = floorDao;
	}

	public void resetTemporarilyOccupiedFloors() {
		floorDao.resetTemporarilyOccupiedFloors();

	}

}
