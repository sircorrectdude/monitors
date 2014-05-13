package com.evodat.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.evodat.dao.ScreenDao;
import com.evodat.model.Screen;

@Repository("screenDao")
public class ScreenDaoHibernate extends GenericDaoHibernate<Screen, Long>
		implements ScreenDao {

	public ScreenDaoHibernate() {
		super(Screen.class);
	}

	public Screen save(Screen screen) {
		return this.saveScreen(screen);
	}

	public Screen saveScreen(Screen screen) {
		if (log.isDebugEnabled()) {
			log.debug("screen id: " + screen.getId());
		}
		getHibernateTemplate().saveOrUpdate(screen);
		getHibernateTemplate().flush();
		return screen;
	}

}
