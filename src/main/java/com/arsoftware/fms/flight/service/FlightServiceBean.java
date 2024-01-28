package com.arsoftware.fms.flight.service;

import com.arsoftware.fms.flight.dto.FlightDTO;
import com.arsoftware.fms.flight.persistence.db.FlightRepository;
import com.arsoftware.fms.flight.persistence.entity.Flight;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightServiceBean implements FlightService {

    FlightRepository<Flight> flightRepository;

    @Override
    public FlightDTO getFlight(long flightId) throws Exception {
        Optional<Flight> flightOptional = flightRepository.findById(flightId);
        if (flightOptional.isPresent()) {
            Flight flight = flightOptional.get();
            return new FlightDTO(
                    flight.getId(),
                    flight.getPlaneId(),
                    flight.getCompanyId());
        } else {
            throw new Exception("Flight is not found in the system");
        }
    }

    @Override
    public List<FlightDTO> getFlightList() {
        List<Flight> flightList = flightRepository.findAll();
        return flightList.stream().map(flight -> new FlightDTO(1l,
                        1L,
                        1L))
                .collect(Collectors.toList());
    }
}
