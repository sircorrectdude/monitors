package com.evodat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.compass.annotations.SearchableId;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "course")
public class Course extends BaseObject implements Serializable {

	private static final long serialVersionUID = 4564797953067007330L;

	private Long id;

	private List<Screen> screens;

	private String name;

	@Column(name = "order_type", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private CourseMode courseMode;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SearchableId
	public Long getId() {
		return id;
	}

	//private Set<Monitor> monitors;

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
				.append("courseMode", courseMode.name()).append("name", name)
				.toString();

	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "course", cascade = CascadeType.ALL)
	public List<Screen> getScreens() {
		return screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}

	public CourseMode getCourseMode() {
		return courseMode;
	}

	public void setCourseMode(CourseMode courseMode) {
		this.courseMode = courseMode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
