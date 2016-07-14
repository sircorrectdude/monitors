package com.evodat.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.compass.annotations.SearchableId;

@Entity
@Table(name = "carparkhistory")
public class CarparkHistory extends BaseObject implements Serializable {

	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	private int freeplaces;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SearchableId
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getFreeplaces() {
		return freeplaces;
	}

	public void setFreeplaces(int freeplaces) {
		this.freeplaces = freeplaces;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarparkHistory other = (CarparkHistory) obj;
		if (freeplaces != other.freeplaces)
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + freeplaces;
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "CarparkHistory [timestamp=" + timestamp + ", freeplaces="
				+ freeplaces + "]";
	}

}
