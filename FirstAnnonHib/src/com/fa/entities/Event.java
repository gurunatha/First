package com.fa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "EVENT", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"EVENT_DT", "PLACE" }) })
public class Event {
	@Id
	@Column(name = "EVENT_ID")
	private int id;
	@Column(name = "DESCR", nullable = false)
	private String description;
	@Column(name = "EVENT_DT", nullable = false)
	private Date eventDate;
	@Column(name = "PLACE", nullable = false)
	private String place;
	@Transient
	private int priority;
	private boolean reminder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean getReminder() {
		return reminder;
	}

	public void setReminder(boolean reminder) {
		this.reminder = reminder;
	}

}
