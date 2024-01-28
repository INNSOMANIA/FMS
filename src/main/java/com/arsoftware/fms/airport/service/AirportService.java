package com.arsoftware.fms.airport.service;

import com.arsoftware.fms.airport.dto.AirportDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AirportService {

    AirportDTO getAirport(long airportId) throws Exception;

    List<AirportDTO> getAirportList();
}
