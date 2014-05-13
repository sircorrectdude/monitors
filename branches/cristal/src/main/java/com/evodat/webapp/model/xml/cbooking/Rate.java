package com.evodat.webapp.model.xml.cbooking;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(value = "Rates")
public class Rate {

	private String date;
	private String single;

	@XStreamAlias(value = "double")
	private String doubleRoom;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSingle() {
		return single;
	}

	public void setSingle(String single) {
		this.single = single;
	}

	public String getDoubleRoom() {
		return doubleRoom;
	}

	public void setDoubleRoom(String doubleRoom) {
		this.doubleRoom = doubleRoom;
	}

}
