package com.Service;

import java.util.ArrayList;

import com.flightDao.FlightDAOImpl;
import com.flightDto.FlightDTO;

public class insertListOfRecordsTester {

	public static void main(String[] args) {
		
		FlightDAOImpl daoImpl=new FlightDAOImpl();
		
		FlightDTO dto =new FlightDTO(9, "BritishAirways", 400, 7.00, "pune", "mumbai");
		
		FlightDTO dto1 =new FlightDTO(10, "Quatar", 300, 3.00, "hyderabad", "mumbai");
		
		FlightDTO dto2 =new FlightDTO(11, "Kingfisher", 200, 2.00, "chennai", "vishakapatnam");
		
		ArrayList<FlightDTO> flightDTOs=new ArrayList<FlightDTO>();
		
		flightDTOs.add(dto);
		flightDTOs.add(dto1);
		flightDTOs.add(dto2);
		
		daoImpl.insertListOfRecords(flightDTOs);
	}

}
