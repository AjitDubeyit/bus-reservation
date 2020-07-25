package com.example.AltimetrikAssesmentTest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.AltimetrikAssesmentTest.entity.BusDetail;
import com.example.AltimetrikAssesmentTest.model.BusDetailRequest;
import com.example.AltimetrikAssesmentTest.service.BusDetailServiceDef;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(MockitoJUnitRunner.Silent.class)
public class BusControllerTest {
	
	
	@InjectMocks
	BusController busController;
	
	@Mock
	BusDetailServiceDef busDetailServiceDef;
	
	//@Autowired
    //private TestRestTemplate restTemplate; 
	
	@Test
	public void getBusDetailsTest() {
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
		Mockito.when(busDetailServiceDef.getAllBusDetail()).thenReturn(busList);
		List<BusDetail> busLst = busController.getBusDetails();
		Assert.assertNotNull("List should not be null",busLst);
		Assert.assertEquals("List should have atleast on value", 1,busLst.size());
	}
	
	@Test
	public void getBusSearchDetailsTest() {
		BusDetailRequest busDetailRequest =  getBusDetailRequest();
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
		Mockito.when(busDetailServiceDef.getBusDetail(busDetailRequest.getSource(), busDetailRequest.getDestination(), busDetailRequest.getDepartureDate())).thenReturn(busList);
		Mockito.when(busDetailServiceDef.getBusDetail(busDetailRequest.getDestination(), busDetailRequest.getSource(), busDetailRequest.getArrivalDate())).thenReturn(busList);
		Map<String, List<BusDetail>> busMapList = busController.getBusSearchDetails(busDetailRequest);
		Assert.assertNotNull("Map should not be null", busMapList);
		Assert.assertEquals("Map should have one value", 2,  busMapList.size());
			
	}
	
	private BusDetailRequest getBusDetailRequest() {
		BusDetailRequest busDetailRequest = new BusDetailRequest();
		busDetailRequest.setSource("PUNE");
		busDetailRequest.setDestination("INDORE");
		busDetailRequest.setDepartureDate(new Date());
		busDetailRequest.setArrivalDate(new Date());
		return busDetailRequest;
	}
	

}
