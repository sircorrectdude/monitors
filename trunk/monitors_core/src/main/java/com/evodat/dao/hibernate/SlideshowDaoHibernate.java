package com.evodat.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.evodat.dao.SlideshowDao;
import com.evodat.model.Slideshow;
import com.evodat.model.Template;

@Repository("slideshowDao")
public class SlideshowDaoHibernate extends GenericDaoHibernate<Slideshow, Long>
		implements SlideshowDao {
	public SlideshowDaoHibernate() {
		super(Slideshow.class);
	}

	public Slideshow getSlideshow(Template template) {

		List<Slideshow> slideshows = getHibernateTemplate().find(
				"from Slideshow where template=?", template);

		if (slideshows == null || slideshows.isEmpty()) {
			return null;
		} else {
			Slideshow slideshow = (Slideshow) slideshows.get(0);
			// log.debug(monitor);
			return slideshow;
		}

	}
}
