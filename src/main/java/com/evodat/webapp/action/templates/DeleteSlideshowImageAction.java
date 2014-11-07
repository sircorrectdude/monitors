package com.evodat.webapp.action.templates;

import java.util.Set;

import com.evodat.model.Slideshow;
import com.evodat.model.SlideshowImage;
import com.evodat.model.Template;
import com.evodat.webapp.action.BaseAction;

public class DeleteSlideshowImageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4427712024032743530L;
	private Template template;
	private String qquuid;

	@Override
	public String execute() throws Exception {
		Slideshow slideshow = slideshowManager.getSlideshow(template);
		SlideshowImage image = null;
		log.info("qquuid " + qquuid);
		Set<SlideshowImage> slideshowImages = slideshow.getSlideshowImages();
		for (SlideshowImage slideshowImage : slideshowImages) {
			log.info("slideshowImage.getId() " + slideshowImage.getId());
			if (String.valueOf(slideshowImage.getId()).equals(qquuid)) {
				image = slideshowImage;
			}
		}
		log.info("slideshowImages SIZE " + slideshowImages.size());
		slideshowImages.remove(image);
		log.info("slideshowImages SIZE " + slideshowImages.size());
		slideshow.setSlideshowImages(slideshowImages);
		log.info(slideshow);
		slideshowManager.save(slideshow);
		return SUCCESS;

	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public String getQquuid() {
		return qquuid;
	}

	public void setQquuid(String qquuid) {
		this.qquuid = qquuid;
	}

}
