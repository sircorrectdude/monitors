package com.evodat.webapp.action;

import java.util.Collections;
import java.util.List;

import com.evodat.model.Carpark;
import com.evodat.model.Floor;
import com.evodat.model.FloorState;

public class FloorAction extends BaseAction {

	private static final long serialVersionUID = -2009992023903159936L;
	private static final FloorState[] floorStates = FloorState.values();
	private Floor floor;
	private List<Floor> floors;

	private String floorId;
	private String floorStateName;

	Carpark carpark;

	public String list() {
		floors = floorManager.getAll();
		// calculate the places left for each Floor
		Collections.sort(floors);
		setFloorPlacesLeft(floors);

		carpark = carparkManager.get(Carpark.Cristal);

		return SUCCESS;
	}

	public String saveFloorState() {
		floor = floorManager.get(Long.valueOf(floorId));
		// FloorState floorState = floorManager.getFloorState(floorStateName);
		FloorState floorState = FloorState.valueOf(floorStateName);
		floor.setFloorState(floorState);
		floor = floorManager.save(floor);
		return SUCCESS;
	}

	public String updateCarpark() {
		// carpark = carparkManager.get(Carpark.Cristal);
		// carpark.setPlacesOccupied(ca)
		carparkManager.save(carpark);
		addActionMessage("Carpark Updated: " + carpark.getPlacesOccupied()
				+ " places left");
		return SUCCESS;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}

	public FloorState[] getFloorstates() {
		return floorStates;
	}

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getFloorStateName() {
		return floorStateName;
	}

	public void setFloorStateName(String floorStateName) {
		this.floorStateName = floorStateName;
	}

	public Carpark getCarpark() {
		return carpark;
	}

	public void setCarpark(Carpark carpark) {
		this.carpark = carpark;
	}

	private void setFloorPlacesLeft(List<Floor> floors) {
		int placesTemp = 0;
		for (Floor floor : floors) {
			// log.info("floor:" + floor);
			// log.info("placesTemp:" + placesTemp);
			int placesLeft = floor.getPlaces() + placesTemp
					- floor.getCarpark().getPlacesOccupied();
			// log.info(placesLeft);
			if (placesLeft < 0) {
				// floor.setPlacesLeft(floor.getPlaces())
				log.info("occupied:" + floor);
				floor.setPlacesLeft(0);
			} else {
				if (placesLeft < floor.getPlaces()) {
					floor.setPlacesLeft(placesLeft);
				} else {
					floor.setPlacesLeft(floor.getPlaces());
				}
				log.info("free:" + floor.getPlacesLeft());
			}
			placesTemp += floor.getPlaces();
		}
	}

}
