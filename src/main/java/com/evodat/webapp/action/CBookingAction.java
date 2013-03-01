package com.evodat.webapp.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.evodat.webapp.model.xml.cbooking.CBooking;
import com.evodat.webapp.model.xml.cbooking.Rate;
import com.evodat.webapp.util.Util;
import com.thoughtworks.xstream.XStream;

public class CBookingAction extends BaseAction {

	private static final long serialVersionUID = -5817541484086719183L;
	private static Logger logger = Logger.getLogger(CBookingAction.class);
	private static final String CBOOKING_API_URL = "http://www.cbooking.de/GetDailyPublicRates.aspx?propertyID=B53DFE44-E66C-4333-88EF-4086A7957013";

	private CBooking cBooking;

	@Override
	public String execute() throws Exception {

		XStream xstream = new XStream();

		String xmlString = Util.convertStreamToString(Util
				.getPage(CBOOKING_API_URL));
		logger.info(xmlString);

		xstream.processAnnotations(CBooking.class);
		cBooking = (CBooking) xstream.fromXML(xmlString);
		List<Rate> rates = cBooking.getRates();

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);

		for (Rate rate : rates) {
			Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(rate
					.getDate().substring(0, 10));
			if (parsedDate.getTime() == calendar.getTime().getTime()) {
				if (Double.parseDouble(rate.getSingle()) > 0
						|| Double.parseDouble(rate.getDoubleRoom()) > 0) {
					cBooking.setRoomsAvailable(true);
					break;
				}
			}
		}
		return SUCCESS;
	}

	public CBooking getcBooking() {
		return cBooking;
	}

	public void setcBooking(CBooking cBooking) {
		this.cBooking = cBooking;
	}

}
