package com.evodat.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.evodat.dao.CarparkDao;
import com.evodat.model.Carpark;

@Repository("carparkDao")
public class CarparkDaoHibernate extends GenericDaoHibernate<Carpark, Long>
		implements CarparkDao {

	public CarparkDaoHibernate() {
		super(Carpark.class);
	}

}
