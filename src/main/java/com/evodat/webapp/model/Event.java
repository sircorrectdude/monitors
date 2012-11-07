package com.evodat.webapp.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Event {
	private String dateString;
	private String dateStringEn;
	private String startString;
	private String startStringEn;
	private String endString;
	private String timeString;
	private String roomName;
	private String roomId;
	private String roomLocation;
	private String logo;
	private String company;

	public String getDateString() {
		return dateString;
	}

	public String getStartString() {
		return startString;
	}

	public void setStartString(String startString) {
		this.startString = startString;
	}

	public String getEndString() {
		return endString;
	}

	public void setEndString(String endString) {
		this.endString = endString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getLogo() {
		return logo;
	}

	public String getRoomLocation() {
		return roomLocation;
	}

	public void setRoomLocation(String roomLocation) {
		this.roomLocation = roomLocation;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getStartStringEn() {
		return startStringEn;
	}

	public void setStartStringEn(String startStringEn) {
		this.startStringEn = startStringEn;
	}

	public String getDateStringEn() {
		return dateStringEn;
	}

	public void setDateStringEn(String dateStringEn) {
		this.dateStringEn = dateStringEn;
	}

	@Override
	public String toString() {
		ToStringBuilder sb = new ToStringBuilder(this,
				ToStringStyle.DEFAULT_STYLE).append("company", this.company)
				.append("logo", this.logo)
				.append("roomLocation", this.roomLocation)
				.append("roomName", this.roomName)
				.append("timeString", this.timeString)
				.append("endString", this.endString)
				.append("startStringEn", this.startStringEn)
				.append("startString", this.startString)
				.append("dateStringEn", this.dateStringEn)
				.append("dateString", this.dateString);
		return sb.toString();
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

}
