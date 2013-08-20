package com.evodat.dao;

import com.evodat.model.Floor;

public interface FloorDao extends GenericDao<Floor, Long> {

	void resetTemporarilyOccupiedFloors();

}
