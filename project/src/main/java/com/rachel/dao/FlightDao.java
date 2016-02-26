package com.rachel.dao;

import java.util.List;

import com.rachel.model.Flight;

public interface FlightDao {
	public Boolean addFlight(Flight flight);

	public List<Flight> getAllFlights();
	
	public Boolean removeFlightByFlightNo (String flightNo);
	
	public Flight getFlightByFlightNo (String flightNo);
}
