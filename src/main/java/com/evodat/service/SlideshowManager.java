package com.evodat.service;

import com.evodat.model.Slideshow;
import com.evodat.model.Template;

public interface SlideshowManager extends GenericManager<Slideshow, Long> {

	public Slideshow getSlideshow(Template template);

}
