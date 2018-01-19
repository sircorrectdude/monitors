package com.evodat.service;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import com.evodat.model.LicensePlate;

@WebService
public interface LicensePlateService {
	List<LicensePlate> getAllByDates(Date startDate, Date endDate);
}
