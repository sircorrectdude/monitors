package com.evodat.webapp.action;

import java.util.Date;
import java.util.List;

import com.evodat.model.LicensePlate;

public class AnprAdminAction extends BaseAction{

	private Date startDate = new Date(new Date().getTime()-1000*60*60*24);
	private Date endDate= new Date();
	List<LicensePlate> licensePlates;
	@Override
	public String execute() throws Exception {
		log.debug("AnprAdminAction startDate:" + startDate+ "endDate:"+endDate);
		licensePlates = licensePlateManager.getAllByDates(startDate, endDate);
		log.debug("got plates:"+licensePlates.size() );
		return SUCCESS;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<LicensePlate> getLicensePlates() {
		return licensePlates;
	}

	public void setLicensePlates(List<LicensePlate> licensePlates) {
		this.licensePlates = licensePlates;
	}

	
}
