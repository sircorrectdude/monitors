package com.evodat.dao.hibernate;

import com.evodat.dao.PortionDao;
import com.evodat.model.Portion;
import org.springframework.stereotype.Repository;

@Repository("portionDao")
public class PortionDaoHibernate extends GenericDaoHibernate<Portion, Long>
		implements PortionDao {

    public PortionDaoHibernate() {
        super(Portion.class);
    }

}
