package com.evodat.dao.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.evodat.dao.LicensePlateDao;
import com.evodat.model.LicensePlate;

@Repository("licensePlateDao")
public class LicensePlateDaoHibernate extends GenericDaoHibernate<LicensePlate, Long> implements LicensePlateDao {
	public LicensePlateDaoHibernate() {
		super(LicensePlate.class);
	}

	// public List<LicensePlate> getAllByDates(Date startDate, Date endDate) {
	// List<LicensePlate> licensePlates = getHibernateTemplate().find(
	// "from LicensePlate where timestamp>=? and timestamp<=?",
	// startDate, endDate);
	//
	// return licensePlates;
	// }

	public List<LicensePlate> getAllByDates(Date startDate, Date endDate) {
		String queryString = "SELECT DATE_FORMAT( MIN(timestamp), '%d/%m/%Y %H:%i:%s' ) AS tmstamp, plate, COUNT(id) AS cnt FROM LicensePlate where timestamp>=? and timestamp<=? GROUP BY ROUND(UNIX_TIMESTAMP(timestamp) / 60), plate";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = session.createQuery(queryString).setParameter(0, startDate).setParameter(1, endDate);
		List<Object[]> list = (List<Object[]>) query.list();
		System.out.println(list.size());

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		List<LicensePlate> plateList = new ArrayList<LicensePlate>();
		for (Object[] row : list) {

			LicensePlate licensePlate = new LicensePlate();

			String plate = (String) row[1];

			licensePlate.setPlate(plate);
			try {
				String tmstamp = (String) row[0];
				licensePlate.setTimestamp(format.parse(tmstamp));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			plateList.add(licensePlate);
		}
		Collections.sort(plateList);
		return plateList;
	}

}
