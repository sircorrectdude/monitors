package com.evodat.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.compass.annotations.SearchableId;

@Entity
@Table(name = "room")
public class Room {

	public static final String RUBIN_1_2 = "4";
	public static final String RUBIN_1 = "5";
	public static final String RUBIN_2 = "6";
	// public static final String DIAMANT_1_2 = "10";
	public static final String CARAT_JUWEL = "7";
	public static final String JUWEL = "8";
	public static final String CARAT = "9";
	public static final String SAPHIR = "11";
	private String id;
	private String name;
	private String location;

	@Id
	@SearchableId
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		ToStringBuilder sb = new ToStringBuilder(this,
				ToStringStyle.DEFAULT_STYLE).append("name", this.name).append(
				"location", this.location);
		return sb.toString();
	}

}
