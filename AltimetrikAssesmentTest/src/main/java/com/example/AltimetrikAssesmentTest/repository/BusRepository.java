package com.example.AltimetrikAssesmentTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.AltimetrikAssesmentTest.entity.BusDetail;


public interface BusRepository extends JpaRepository<BusDetail, Integer> {
	
	@Query(value = "select * from bus_detail u where u.bus_number = :busNumber", nativeQuery = true)
	List<BusDetail> findByBusName(@Param("busNumber") String busNumber);
	 
	
	@Query(value = "select * from bus_detail b where b.SOURCE_CITY = :sourceName and "
			+ "b.DESTINATION_CITY = :destName and Date(b.DEPARTURE) = :departureDate", nativeQuery = true)
	List<BusDetail> findBySourceDestinationDeparture(@Param("sourceName") String sourceName, @Param("destName") String destName, @Param("departureDate") String departureDate);
	
	
	@Query(value ="select a.BUS_NUMBER,a.OPERATOR_NAME,a.DEPARTURE,a.ARRIVAL_TIME,a.PRICE,"
			+ "a.SOURCE_CITY,a.DESTINATION_CITY from bus_detail a",nativeQuery = true)
	List<BusDetail> findBus();
	
	@Query(value = "select * from bus_detail b where b.SOURCE_CITY = :sourceName and "
			+ "b.DESTINATION_CITY = :destName and Date(b.ARRIVAL_TIME) = :arrivalDate", nativeQuery = true)
	List<BusDetail> getArrivalBusDetails(@Param("sourceName") String sourceName, @Param("destName") String destName, @Param("arrivalDate") String arrivalDate);
	
	
}
