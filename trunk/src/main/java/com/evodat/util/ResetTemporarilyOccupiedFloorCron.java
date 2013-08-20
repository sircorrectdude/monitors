package com.evodat.util;

import org.springframework.scheduling.annotation.Scheduled;

import com.evodat.service.FloorManager;

public class ResetTemporarilyOccupiedFloorCron {

	/**
	 * The FloorManager
	 */
	protected FloorManager floorManager;

	// @Scheduled(cron = "*/20 * * * * ?")
	@Scheduled(cron = "0 0 * * * ?")
	public void resetTemporarilyOccupiedFloors() {
		floorManager.resetTemporarilyOccupiedFloors();
	}

	public void setFloorManager(FloorManager floorManager) {
		this.floorManager = floorManager;
	}

}
