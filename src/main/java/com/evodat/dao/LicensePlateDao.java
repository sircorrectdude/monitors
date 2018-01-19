package com.evodat.dao;

import java.util.Date;
import java.util.List;

import com.evodat.model.LicensePlate;

public interface LicensePlateDao extends GenericDao<LicensePlate, Long>{

	List<LicensePlate> getAllByDates(Date startDate, Date endDate);

}
