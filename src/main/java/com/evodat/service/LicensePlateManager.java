package com.evodat.service;

import java.util.Date;
import java.util.List;

import com.evodat.model.LicensePlate;

public interface LicensePlateManager extends GenericManager<LicensePlate, Long>{

	List<LicensePlate> getAllByDates(Date startDate, Date endDate);

}
