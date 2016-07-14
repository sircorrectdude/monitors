package com.evodat.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.evodat.dao.CarparkHistoryDao;
import com.evodat.model.CarparkHistory;

@Repository("carparkHistoryDao")
public class CarparkHistoryDaoHibernate extends
		GenericDaoHibernate<CarparkHistory, Long> implements CarparkHistoryDao {
	public CarparkHistoryDaoHibernate() {
		super(CarparkHistory.class);
	}

	public List<CarparkHistory> getAllByDates(Date startDate, Date endDate) {
		List<CarparkHistory> carparkHistories = getHibernateTemplate().find(
				"from CarparkHistory where timestamp>? and timestamp<=?",
				startDate, endDate);

		return carparkHistories;
	}
}
