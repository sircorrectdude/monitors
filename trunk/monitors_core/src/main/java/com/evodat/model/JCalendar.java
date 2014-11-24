package com.evodat.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.compass.annotations.SearchableId;

@Entity
@Table(name = "jqcalendar")
public class JCalendar extends BaseObject implements Serializable {

	private static final long serialVersionUID = 3004170449523009337L;

	private Integer id;

	private String subject;
	private String location;
	private String description;
	private Room color;
	private String recurringRule;
	private Short isAllDayEvent;
	private Date startTime;
	private Date endTime;

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SearchableId
	public Integer getId() {
		return id;
	}

	@Column(name = "Location", length = 200)
	public String getLocation() {
		return location;
	}

	@Column(name = "Subject", length = 1000)
	public String getSubject() {
		return subject;
	}

	@ManyToOne
	@JoinColumn(name = "Color")
	public Room getColor() {
		return color;
	}

	@Column(name = "StartTime")
	public Date getStartTime() {
		return startTime;
	}

	@Column(name = "EndTime")
	public Date getEndTime() {
		return endTime;
	}

	@Column(name = "Description", length = 255)
	public String getDescription() {
		return description;
	}

	@Column(name = "RecurringRule", length = 500)
	public String getRecurringRule() {
		return recurringRule;
	}

	@Column(name = "IsAllDayEvent", nullable = false)
	public Short getIsAllDayEvent() {
		return isAllDayEvent;
	}

	public void setIsAllDayEvent(Short isAllDayEvent) {
		this.isAllDayEvent = isAllDayEvent;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setColor(Room color) {
		this.color = color;
	}

	public void setRecurringRule(String recurringRule) {
		this.recurringRule = recurringRule;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		ToStringBuilder sb = new ToStringBuilder(this,
				ToStringStyle.DEFAULT_STYLE).append("subject", this.subject)
				.append("location", this.location)
				.append("description", this.description)
				.append("color", this.color)
				.append("isAllDayEvent", this.isAllDayEvent)
				.append("startTime", this.startTime)
				.append("endTime", this.endTime)
				.append("recurringRule", this.recurringRule);
		return sb.toString();
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

}
