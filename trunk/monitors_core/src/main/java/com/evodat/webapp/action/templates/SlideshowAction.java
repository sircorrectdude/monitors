package com.evodat.webapp.action.templates;

import com.evodat.model.Slideshow;
import com.evodat.model.Template;
import com.evodat.webapp.action.BaseAction;

public class SlideshowAction extends BaseAction {

	private static final long serialVersionUID = -5450922265455704236L;
	private Slideshow slideshow;
	private String templateId;

	@Override
	public String execute() throws Exception {
		Template template = new Template();
		template.setId(Long.valueOf(templateId));
		slideshow = slideshowManager.getSlideshow(template);
		return SUCCESS;

	}

	public Slideshow getSlideshow() {
		return slideshow;
	}

	public void setSlideshow(Slideshow slideshow) {
		this.slideshow = slideshow;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

}
