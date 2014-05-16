package com.evodat.service.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evodat.dao.SlideshowDao;
import com.evodat.model.Slideshow;
import com.evodat.model.Template;
import com.evodat.service.SlideshowManager;

@Service("slideshowManager")
@WebService(serviceName = "SlideshowService", endpointInterface = "com.evodat.service.SlideshowService")
public class SlideshowManagerImpl extends GenericManagerImpl<Slideshow, Long>
		implements SlideshowManager {

	private SlideshowDao slideshowDao;

	@Autowired
	public void setSlideshowDao(SlideshowDao slideshowDao) {
		this.dao = slideshowDao;
		this.slideshowDao = slideshowDao;
	}

	public Slideshow getSlideshow(Template template) {
		return slideshowDao.getSlideshow(template);

	}

}
