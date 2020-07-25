package com.example.AltimetrikAssesmentTest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="bus_detail")
@Entity
public class BusDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="BUS_NUMBER")
	String busNumber;
	
	
	@Column(name="OPERATOR_NAME")
	String operatorName;
	
	@Column(name="DEPARTURE")
	Date departure;
	
	@Column(name="ARRIVAL_TIME")
	Date arrivalTime;
	
	@Column(name="PRICE")
	double price;
	
	@Column(name="SOURCE_CITY")
	String sourceCity;
	
	@Column(name="DESTINATION_CITY")
	String destinationCity;
	
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public Date getDeparture() {
		return departure;
	}
	public void setDeparture(Date departure) {
		this.departure = departure;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSourceCity() {
		return sourceCity;
	}
	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
}
