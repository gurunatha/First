package com.mtm.dto;

import java.util.Date;

public class TripDetailsDto {
	private String source;
	private String destination;
	private Date tripDate;
	private long noOfPassengers;

	public TripDetailsDto(String source, String destination, Date tripDate,
			int noOfPassengers) {
		this.source = source;
		this.destination = destination;
		this.tripDate = tripDate;
		this.noOfPassengers = noOfPassengers;
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

	public Date getTripDate() {
		return tripDate;
	}

	public void setTripDate(Date tripDate) {
		this.tripDate = tripDate;
	}

	public long getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(long noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	@Override
	public String toString() {
		return "TripDetailsDto [source=" + source + ", destination="
				+ destination + ", tripDate=" + tripDate + ", noOfPassengers="
				+ noOfPassengers + "]";
	}

}
