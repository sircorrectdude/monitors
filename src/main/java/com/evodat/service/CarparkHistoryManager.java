package com.evodat.service;

import java.util.Date;
import java.util.List;

import com.evodat.model.CarparkHistory;

public interface CarparkHistoryManager extends GenericManager<CarparkHistory, Long> {

	List<CarparkHistory> getAllByDates(Date startDate, Date endDate);

}
