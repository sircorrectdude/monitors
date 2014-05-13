package com.evodat.service;

import com.evodat.model.Floor;

public interface FloorManager extends GenericManager<Floor, Long> {

	void resetTemporarilyOccupiedFloors();

}
