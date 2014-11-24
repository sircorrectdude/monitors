package com.evodat.webapp.model.xml.cbooking;

import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias(value = "DocumentElement")
public class CBooking {

	@XmlTransient
	private boolean roomsAvailable;

	@XStreamImplicit(itemFieldName = "Rates")
	private List<Rate> rates;

	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	public boolean isRoomsAvailable() {
		return roomsAvailable;
	}

	public void setRoomsAvailable(boolean roomsAvailable) {
		this.roomsAvailable = roomsAvailable;
	}

}
