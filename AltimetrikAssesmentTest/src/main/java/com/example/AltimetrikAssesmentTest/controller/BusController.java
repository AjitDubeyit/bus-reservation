package com.example.AltimetrikAssesmentTest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.AltimetrikAssesmentTest.config.BusConstant;
import com.example.AltimetrikAssesmentTest.entity.BusDetail;
import com.example.AltimetrikAssesmentTest.model.BusDetailRequest;
import com.example.AltimetrikAssesmentTest.service.BusDetailServiceDef;

@RestController
public class BusController {

	@Autowired
	BusDetailServiceDef busDetailServiceDef;

	@GetMapping("/busDetail")
	public List<BusDetail> getBusDetails() {
		System.out.println("inside getBusDetails()" );
		List<BusDetail> busList = busDetailServiceDef.getAllBusDetail();
		return busList;
	}

	@PostMapping("/busSearchDetail")
	public Map<String, List<BusDetail>> getBusSearchDetails(@Validated @RequestBody BusDetailRequest busDetailRequest) {
		System.out.println("inside getBusSearchDetails()" + busDetailRequest.toString());
		Map<String, List<BusDetail>> busMapList = new HashMap<String, List<BusDetail>>();

		if(busDetailRequest.getDepartureDate()!=null && !busDetailRequest.getDepartureDate().equals("")) {
			List<BusDetail> busDetail = busDetailServiceDef.getBusDetail(busDetailRequest.getSource(), busDetailRequest.getDestination(), busDetailRequest.getDepartureDate());
			busMapList.put(BusConstant.DEPARTUREDETAIL, busDetail);
		}

		if(busDetailRequest.getArrivalDate()!=null && !busDetailRequest.getArrivalDate().equals("")) {
			List<BusDetail> arrivalDetails = busDetailServiceDef.getArrivalBusDetail(busDetailRequest.getSource(), busDetailRequest.getDestination(), busDetailRequest.getArrivalDate());
			busMapList.put(BusConstant.ARRIVALDETAIL, arrivalDetails);
		}

		return busMapList;
	}
}
