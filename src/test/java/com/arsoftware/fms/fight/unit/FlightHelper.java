package com.arsoftware.fms.fight.unit;

import com.arsoftware.fms.flight.dto.FlightDTO;
import com.arsoftware.fms.flight.persistence.entity.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightHelper {

    protected static Flight getSampleFlight() {
        Flight flight = new Flight();
        flight.setId(1000L);
        flight.setCompanyId(1L);
        flight.setPlaneId(1L);

        return flight;
    }

    protected static List<Flight> getSampleFlightList() {
        List<Flight> flightList = new ArrayList<>();
        flightList.add(getSampleFlight());
        flightList.add(getSampleFlight());

        return flightList;
    }

    protected static FlightDTO getSampleFlightDTO() {
        return new FlightDTO(1L,
                1L,
                1L);
    }

    protected static List<FlightDTO> getSampleFlightDTOList() {
        List<FlightDTO> flightDTOList = new ArrayList<>();
        flightDTOList.add(new FlightDTO(1L,
                1L,
                1L));

        return flightDTOList;
    }
}
