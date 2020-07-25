package com.example.AltimetrikAssesmentTest.service;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AltimetrikAssesmentTest.entity.BusDetail;
import com.example.AltimetrikAssesmentTest.repository.BusRepository;

@Service
public class BusDetailServiceImpl implements BusDetailServiceDef{

	@Autowired
	BusRepository busRepository;
	
	@Override
	public List<BusDetail> getBusDetail(String sourceName, String destName, Date date) {
		System.out.println("In side getBusDetail() method");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formatedDAte = sdf.format(date);
		System.out.println();
		
		List<BusDetail> busDetail = busRepository.findBySourceDestinationDeparture(sourceName, destName, formatedDAte);

		busDetail=busDetail.stream().sorted(Comparator.comparing(BusDetail::getOperatorName).
				thenComparing(BusDetail::getDeparture).thenComparing(BusDetail::getArrivalTime))
				.collect(Collectors.toList());
		//.thenComparing(Math.subtractExact(BusDetail::getDeparture,BusDetail::getArrivalTime))

		return busDetail;
	}

	@Override
	public List<BusDetail> getAllBusDetail() {
		System.out.println("Inside getAllBusDetail()");
		List<BusDetail> busList = busRepository.findAll();
		return busList;
	}

	@Override
	public List<BusDetail> getArrivalBusDetail(String sourceName, String destName, Date arrivalDate) {
		System.out.println("In side getArrivalBusDetail() method");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formatedArrivalDate  = sdf.format(arrivalDate);
		
		List<BusDetail> busDetail = busRepository.getArrivalBusDetails(destName, sourceName, formatedArrivalDate);

		busDetail=busDetail.stream().sorted(Comparator.comparing(BusDetail::getOperatorName).
				thenComparing(BusDetail::getDeparture).thenComparing(BusDetail::getArrivalTime))
				.collect(Collectors.toList());
		//.thenComparing(Math.subtractExact(BusDetail::getDeparture,BusDetail::getArrivalTime))

		return busDetail;
	
	}


}
