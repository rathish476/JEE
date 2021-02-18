package com.Service;

import com.flightDao.FlightDAO;
import com.flightDao.FlightDAOImpl;
import com.flightDto.FlightDTO;

public class UpdateRecordTester {

	public static void main(String[] args) {
		
		FlightDTO flightDTO=new FlightDTO();
		
		FlightDAO flightDAO=new FlightDAOImpl();
		
		boolean res=flightDAO.updateRecordByFlightId("Quatar", "man");
		
		if(res) {
			System.out.println("record updation successfull "+res);
		}else {
			System.out.println("record updation not done");
		}

	}

}
