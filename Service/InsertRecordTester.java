package com.Service;

import com.flightDao.FlightDAO;
import com.flightDao.FlightDAOImpl;
import com.flightDto.FlightDTO;

public class InsertRecordTester {

	public static void main(String[] args) {


		FlightDTO flightDTO=new FlightDTO(8, "AIRair", 100, 12.00,"pune", "mumbai");		
		FlightDAO flightDAO=new FlightDAOImpl();
		
		boolean record=flightDAO.insertRecord(flightDTO);

		if(record) {
			System.out.println("insertion succesfull "+record);
		}
		else {
			System.out.println("insertion not done");
		}
	}

}