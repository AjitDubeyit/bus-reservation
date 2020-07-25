package com.example.AltimetrikAssesmentTest.service;

import java.util.Date;
import java.util.List;

import com.example.AltimetrikAssesmentTest.entity.BusDetail;

public interface BusDetailServiceDef {
	
	public List<BusDetail> getBusDetail(String sourceName, String destName, Date departureDate);
	
	public List<BusDetail> getAllBusDetail();
	
	public List<BusDetail> getArrivalBusDetail(String sourceName, String destName, Date arrivalDate);

}
