package com.arsoftware.fms.flight.service;

import com.arsoftware.fms.flight.dto.FlightDTO;

import java.util.List;

public interface FlightService {

    FlightDTO getFlight(long flightId) throws Exception;

    List<FlightDTO> getFlightList();

}
