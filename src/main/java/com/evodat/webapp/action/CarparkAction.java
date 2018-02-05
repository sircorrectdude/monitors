package com.evodat.webapp.action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.evodat.model.Carpark;
import com.evodat.model.Floor;
import com.evodat.model.FloorState;
import com.evodat.model.Monitor;
import com.evodat.service.MonitorNotFoundException;
import com.opensymphony.xwork2.Preparable;

public class CarparkAction extends BaseAction implements ServletRequestAware,
		Preparable {

	private static final long serialVersionUID = -5105814831702216733L;

	private Carpark carparkCristal;

	protected HttpServletRequest servletRequest;
	private String remoteAddr;
	private String floorName;

	public void prepare() throws Exception {
		remoteAddr = getRequest().getRemoteAddr();
		log.debug("Request from: " + getRequest().getRemoteAddr() + " Method: "
				+ getRequest().getMethod());
		carparkCristal = carparkManager.get(Carpark.Cristal);
	}

	private Integer getPlacesOccupied() {
		return carparkCristal.getPlacesOccupied();
	}

	@Override
	public String execute() throws Exception {

		Monitor monitorByIpAddress;
		try {
			monitorByIpAddress = monitorManager
					.getMonitorByIpAddress(remoteAddr);
			setFloorName(monitorByIpAddress.getAlias().toUpperCase());
		} catch (MonitorNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Floor> floors = carparkCristal.getFloors();

		// calculate the places left for each Floor
		Collections.sort(floors);
		setFloorPlacesLeft(floors);

		// set totalPlacesLeft
		int placesTotal = 0;
		for (Floor floor : floors) {
			placesTotal = placesTotal + floor.getPlaces();
		}
		carparkCristal.setPlacesLeft(placesTotal - getPlacesOccupied());
//		log.info("placesLeftTotal: " + carparkCristal.getPlacesLeft());

		return SUCCESS;
	}

	private void setFloorPlacesLeft(List<Floor> floors) {
		int placesTemp = 0;
		log.info("carparkCristal.getPlacesOccupied():" + getPlacesOccupied());
		for (Floor floor : floors) {
			// log.info("floor:" + floor);
			// log.info("placesTemp:" + placesTemp);
			int placesLeft = 0;
			if (floor.getFloorState() == FloorState.SYSTEM) {
				placesLeft = floor.getPlaces() + placesTemp
						- getPlacesOccupied();
			}
			// log.info(placesLeft);
			if (placesLeft <= 0) {
				// floor.setPlacesLeft(floor.getPlaces())
				log.info("occupied:" + floor);
				floor.setPlacesLeft(0);
			} else {
				if (placesLeft < floor.getPlaces()) {
					floor.setPlacesLeft(placesLeft);
				} else {
					floor.setPlacesLeft(floor.getPlaces());
				}
//				log.debug("free:" + floor.getPlacesLeft());
			}
			placesTemp += floor.getPlaces();

		}

		for (Floor floor : floors) {
			int placesLeftUpper = 0;
			for (Floor upperFloor : floors) {
				if (floor.getSequence() < upperFloor.getSequence()) {
					placesLeftUpper = placesLeftUpper
							+ upperFloor.getPlacesLeft();
				}
			}
			floor.setPlacesLeftUpper(placesLeftUpper);
		}

	}

	public Carpark getCarparkCristal() {
		return carparkCristal;
	}

	public void setCarparkCristal(Carpark carparkCristal) {
		this.carparkCristal = carparkCristal;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

}
