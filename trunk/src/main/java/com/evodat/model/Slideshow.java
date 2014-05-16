package com.evodat.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "slideshow")
public class Slideshow {

	private Long id;
	private Template template;
	private Set<SlideshowImage> slideshowImages = new HashSet<SlideshowImage>();
	private int width;
	private int height;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@ManyToOne
	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	@OneToMany(mappedBy = "slideshow")
	public Set<SlideshowImage> getSlideshowImages() {
		return slideshowImages;
	}

	public void setSlideshowImages(Set<SlideshowImage> slideshowImages) {
		this.slideshowImages = slideshowImages;
	}

}
