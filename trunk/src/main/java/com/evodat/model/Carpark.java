package com.evodat.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@Table(name = "carpark")
public class Carpark {

	public static final Long Cristal = new Long(1);

	private Long id;
	private Integer placesOccupied;
	private Integer placesLeft;
	private String name;
	private List<Floor> floors;

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Transient
	public Integer getPlacesLeft() {
		return placesLeft;
	}

	public void setPlacesLeft(Integer placesLeft) {
		this.placesLeft = placesLeft;
	}

	public Integer getPlacesOccupied() {
		return placesOccupied;
	}

	public void setPlacesOccupied(Integer placesOccupied) {
		this.placesOccupied = placesOccupied;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "carpark", cascade = CascadeType.ALL)
	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(
				"name", name).toString();

	}

}
