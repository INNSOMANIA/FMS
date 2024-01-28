package com.arsoftware.fms.airport.service;

import com.arsoftware.fms.airport.dto.AirportDTO;
import com.arsoftware.fms.airport.persistence.db.AirportRepository;
import com.arsoftware.fms.airport.persistence.entity.Airport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AirportServiceBean implements AirportService {

    AirportRepository<Airport> airportRepository;

    @Override
    public AirportDTO getAirport(long airportId) throws Exception {
        Optional<Airport> airportOptional = airportRepository.findById(airportId);
        if (airportOptional.isPresent()) {
            Airport airport = airportOptional.get();
            return new AirportDTO(
                    airport.getId(),
                    airport.getName());
        } else {
            throw new Exception("Airport is not found in the system");
        }
    }

    @Override
    public List<AirportDTO> getAirportList() {
        List<Airport> airportList = airportRepository.findAll();
        return airportList.stream().map(airport -> new AirportDTO(
                        airport.getId(),
                        airport.getName()))
                .collect(Collectors.toList());
    }
}
