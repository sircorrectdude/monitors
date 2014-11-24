package com.evodat.webapp.action.templates;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import com.evodat.model.Slideshow;
import com.evodat.model.SlideshowImage;
import com.evodat.model.Template;
import com.evodat.webapp.action.BaseAction;

public class SlideshowSessionAction extends BaseAction {

	private static final long serialVersionUID = 8481615945850125985L;

	private transient Template template;

	private transient Slideshow slideshow;

	public Object[] slideShowSessionElements = new Object[] {};

	@Override
	public String execute() throws Exception {
		slideshow = slideshowManager.getSlideshow(template);
		Set<SlideshowSessionAction.SlideShowSessionElement> slideShowSessionElements = new HashSet<SlideshowSessionAction.SlideShowSessionElement>();
		if (slideshow == null) {
			return SUCCESS;
		}
		for (SlideshowImage image : slideshow.getSlideshowImages()) {
			slideShowSessionElements.add(new SlideShowSessionElement(image));
		}
		this.slideShowSessionElements = slideShowSessionElements.toArray();
		return SUCCESS;

	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public void setSlideshow(Slideshow slideshow) {
		this.slideshow = slideshow;
	}

	public Object[] getSlideShowSessionElements() {
		return slideShowSessionElements;
	}

	public void setSlideShowSessionElements(Object[] slideShowSessionElements) {
		this.slideShowSessionElements = slideShowSessionElements;
	}

	public class SlideShowSessionElement {
		private String name;
		private String uuid;
		private String size;
		private String id;
		private String thumbnailUrl;

		public SlideShowSessionElement(SlideshowImage image) {
			this.name = image.getOriginalFilename();
			// this.uuid = image.getName().substring(
			// image.getName().lastIndexOf("."));
			this.uuid = String.valueOf(image.getId());
			this.thumbnailUrl = "images" + File.separator + image.getName();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getThumbnailUrl() {
			return thumbnailUrl;
		}

		public void setThumbnailUrl(String thumbnailUrl) {
			this.thumbnailUrl = thumbnailUrl;
		}

	}

}
