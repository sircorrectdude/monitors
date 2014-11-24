package com.evodat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@Table(name = "floor")
public class Floor implements Comparable<Floor> {

	private Long id;
	private String name;
	private Integer places;
	private Integer sequence;
	private Carpark carpark;

	private Integer placesLeft;
	private Integer placesLeftUpper;

	@Column(name = "order_type", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private FloorState floorState;

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

	@Transient
	public Integer getPlacesLeftUpper() {
		return placesLeftUpper;
	}

	public void setPlacesLeftUpper(Integer placesLeftUpper) {
		this.placesLeftUpper = placesLeftUpper;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPlaces() {
		return places;
	}

	public void setPlaces(Integer places) {
		this.places = places;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public FloorState getFloorState() {
		return floorState;
	}

	public void setFloorState(FloorState floorState) {
		this.floorState = floorState;
	}

	@ManyToOne
	// @JoinTable(name = "carpark_floor", joinColumns = { @JoinColumn(name =
	// "floor_id") }, inverseJoinColumns = @JoinColumn(name = "carpark_id"))
	public Carpark getCarpark() {
		return carpark;
	}

	public void setCarpark(Carpark carpark) {
		this.carpark = carpark;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
				.append("carparkState", floorState.name()).append("name", name)
				.append("places", places).toString();

	}

	public int compareTo(Floor o) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		if (this.getSequence() > o.getSequence())
			return AFTER;
		if (this.getSequence() < o.getSequence())
			return BEFORE;

		return EQUAL;
	}

}
