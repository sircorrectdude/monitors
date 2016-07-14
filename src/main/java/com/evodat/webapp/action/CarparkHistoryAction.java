package com.evodat.webapp.action;

import java.util.Date;
import java.util.List;

import com.evodat.model.CarparkHistory;

public class CarparkHistoryAction extends BaseAction {

	private static final long serialVersionUID = 6319761780881973339L;
	private String datesSeries;
	private double tickIntervalHours;
	private Date startDate = new Date(new Date().getTime()-1000*60*60*24);
	private Date endDate= new Date();
	
	
	@Override
	public String execute() throws Exception {

//		List<CarparkHistory> carparkHistorys = carparkHistoryManager.getAll();
		List<CarparkHistory> carparkHistorys = carparkHistoryManager.getAllByDates(startDate, endDate);
		// [['2011-10-29 6:05',4], ['2011-10-29 6:06',6.5]];

		System.out.println("startDate"+ startDate);
		System.out.println("endDate"+ endDate);
		
		StringBuffer buf = new StringBuffer(1000);
		buf.append("[");

		int freeplace = 0;

		for (CarparkHistory carparkHistory : carparkHistorys) {
			if (freeplace != carparkHistory.getFreeplaces()) {
				buf.append("['" + carparkHistory.getTimestamp() + "',"
						+ carparkHistory.getFreeplaces() + "],");
				freeplace = carparkHistory.getFreeplaces();
			}
		}
		buf.append("]");
		datesSeries = buf.toString();
		
		tickIntervalHours = ((endDate.getTime()-startDate.getTime())/1000.0/60.0/60.0)/10.0;
		System.out.println("tickIntervalHours"+ tickIntervalHours);
		return SUCCESS;

	}

	public String getDatesSeries() {
		return datesSeries;
	}

	public void setDatesSeries(String datesSeries) {
		this.datesSeries = datesSeries;
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

	public double getTickIntervalHours() {
		return tickIntervalHours;
	}

	public void setTickIntervalHours(double tickIntervalHours) {
		this.tickIntervalHours = tickIntervalHours;
	}

}
