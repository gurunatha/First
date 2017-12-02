package com.mtms.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "JOURNEY")
public class Journey {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "JOURNEY_ID")
	protected int journeyId;
	protected String source;
	protected String destination;
	@Column(name = "JOURNEY_DT")
	protected Date journeyDate;
	protected float fare;
	protected int distance;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "JOURNEY_PASSENGERS", joinColumns = { @JoinColumn(name = "JOURNEY_ID") }, inverseJoinColumns = { @JoinColumn(name = "PASSENGER_ID") })
	protected Set<Passenger> passengers;

	public int getJourneyId() {
		return journeyId;
	}

	public void setJourneyId(int journeyId) {
		this.journeyId = journeyId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

	public float getFare() {
		return fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "Journey [journeyId=" + journeyId + ", source=" + source
				+ ", destination=" + destination + ", journeyDate="
				+ journeyDate + ", fare=" + fare + ", distance=" + distance
				+ ", passengers=" + passengers + "]";
	}

}
