package com.example.AltimetrikAssesmentTest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.AltimetrikAssesmentTest.entity.BusDetail;
import com.example.AltimetrikAssesmentTest.model.BusDetailRequest;
import com.example.AltimetrikAssesmentTest.repository.BusRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BusDetailServiceImplTest {
	
	@Mock
	BusRepository busRepository;
	
	@InjectMocks
	BusDetailServiceImpl busDetailService;
	
	@Test
	public void getBusDetailTest() {
		BusDetailRequest busDetailRequest =  getBusDetailRequest();
		List<BusDetail> busList = getBusList();
		Mockito.when(busDetailService.getBusDetail(busDetailRequest.getSource(),busDetailRequest.getDestination(),busDetailRequest.getDepartureDate())).thenReturn(busList);
		List<BusDetail> busLst = busDetailService.getBusDetail(busDetailRequest.getSource(), busDetailRequest.getDestination(), busDetailRequest.getDepartureDate());
		Assert.assertNotEquals("List should not be null", busLst);
		Assert.assertEquals("Bus list should have atleast one bus ", 1, busLst.size());
	}
	
	@Test
	public void getArrivalBusDetail() {
		BusDetailRequest busDetailRequest =  getBusDetailRequest();
		List<BusDetail> arrivalBusList = getBusList();
		Mockito.when(busDetailService.getArrivalBusDetail(busDetailRequest.getSource(),busDetailRequest.getDestination(),busDetailRequest.getArrivalDate())).thenReturn(arrivalBusList);
		List<BusDetail> arrivalBusLst = busDetailService.getArrivalBusDetail(busDetailRequest.getSource(), busDetailRequest.getDestination(), busDetailRequest.getArrivalDate());
		Assert.assertNotEquals("List should not be null", arrivalBusLst);
		Assert.assertEquals("", 1, arrivalBusLst.size());
	}
	
	@Test
	public void getAllBusDetail() {
		List<BusDetail> busList = getBusList();
		Mockito.when(busDetailService.getAllBusDetail()).thenReturn(busList);
		List<BusDetail> allBusList = busDetailService.getAllBusDetail();
		Assert.assertNotEquals("List should not null", allBusList);
		Assert.assertEquals("", 1, allBusList.size());
		
	}
	
	private BusDetailRequest getBusDetailRequest() {
		BusDetailRequest busDetailRequest = new BusDetailRequest();
		busDetailRequest.setSource("PUNE");
		busDetailRequest.setDestination("INDORE");
		busDetailRequest.setDepartureDate(new Date());
		busDetailRequest.setArrivalDate(new Date());
		return busDetailRequest;
	}
	
	private List<BusDetail> getBusList() {
		List<BusDetail> busList = new ArrayList<BusDetail>();
		BusDetail busDetail = new BusDetail();
		busDetail.setBusNumber("busDetail");
		busDetail.setOperatorName("");
		busDetail.setDeparture(new Date());
		busDetail.setArrivalTime(new Date());
		busDetail.setPrice(500);
		busDetail.setSourceCity("PUNE");
		busDetail.setDestinationCity("INDORE");
		busList.add(busDetail);
		return busList;
	}

}
