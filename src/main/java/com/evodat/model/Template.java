package com.evodat.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

@Entity
@Table(name = "template")
@Searchable
public class Template extends BaseObject implements Serializable {

	private static final long serialVersionUID = -8158511957189146295L;

	private Long id;
	private String name;
	private String text;
	private Boolean editable;
	private User user;

	@Column(name = "order_type", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private TemplateType templateType;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SearchableId
	public Long getId() {
		return id;
	}

	@Lob
	@Basic(fetch = FetchType.EAGER)
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@SearchableProperty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);

	}

	public Boolean getEditable() {
		return editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TemplateType getTemplateType() {
		return templateType;
	}

	public void setTemplateType(TemplateType templateType) {
		this.templateType = templateType;
	}

}
