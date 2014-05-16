package com.evodat.dao;

import com.evodat.model.Slideshow;
import com.evodat.model.Template;

public interface SlideshowDao extends GenericDao<Slideshow, Long> {

	Slideshow getSlideshow(Template template);
}
