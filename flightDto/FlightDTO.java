package com.flightDto;

public class FlightDTO {
	
	private int flightId;
	private String name;
	private int fuelCapacity;
	private double airTime;
	private String source;
	private String destination;
	
	public FlightDTO() {
		
	}
	
	
	public FlightDTO(int flightId, String name, int fuelCapacity, double airTime, String source, String destination) {
		super();
		this.flightId = flightId;
		this.name = name;
		this.fuelCapacity = fuelCapacity;
		this.airTime = airTime;
		this.source = source;
		this.destination = destination;
	}


	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public double getAirTime() {
		return airTime;
	}

	public void setArrTime(double airTime) {
		this.airTime = airTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "FlightDTO [flightId=" + flightId + ", name=" + name + ", fuelCapacity=" + fuelCapacity + ", airTime="
				+ airTime + ", source=" + source + ", destination=" + destination + "]";
	}
	
	
}
