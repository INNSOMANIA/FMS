package com.arsoftware.fms.airport.unit;

import com.arsoftware.fms.airport.dto.AirportDTO;
import com.arsoftware.fms.airport.persistence.entity.Airport;

import java.util.ArrayList;
import java.util.List;

public class AirportHelper {

    protected static Airport getSampleAirport() {
        Airport airport = new Airport();
        airport.setId(1000L);
        airport.setName("NAME");

        return airport;
    }

    protected static List<Airport> getSampleAirportList() {
        List<Airport> airportList = new ArrayList<>();
        airportList.add(getSampleAirport());
        airportList.add(getSampleAirport());

        return airportList;
    }

    protected static AirportDTO getSampleAirportDTO() {
        return new AirportDTO(
                1L,
                "NAME");
    }

    protected static List<AirportDTO> getSampleAirportDTOList() {
        List<AirportDTO> airportDTOList = new ArrayList<>();
        airportDTOList.add(new AirportDTO(
                1L,
                "NAME"));

        return airportDTOList;
    }
}
