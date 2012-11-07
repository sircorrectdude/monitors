package com.evodat.webapp.util;

import java.util.List;

public class TrafficInfoDTO {
	List allObjects;
	String time;

	public List getAllObjects() {
		return allObjects;
	}

	public void setAllObjects(List allObjects) {
		this.allObjects = allObjects;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
