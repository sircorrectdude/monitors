package com.evodat.dao;

import java.util.Date;
import java.util.List;

import com.evodat.model.CarparkHistory;

public interface CarparkHistoryDao extends GenericDao<CarparkHistory, Long> {

	List<CarparkHistory> getAllByDates(Date startDate, Date endDate);

}
