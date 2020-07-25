package com.example.AltimetrikAssesmentTest.model;

import java.util.Date;

public class BusDetailRequest {
	
	private String source;
	private String destination;
	private Date departureDate;
	private Date arrivalDate;
	
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
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	@Override
	public String toString() {
		return "BusDetailRequest [source=" + source + ", destination=" + destination + ", departureDate="
				+ departureDate + ", arrivalDate=" + arrivalDate + "]";
	}
	
	
	

}
