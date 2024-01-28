package com.arsoftware.fms.airport.persistence.db;

import com.arsoftware.fms.airport.persistence.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AirportRepository<T extends Airport> extends JpaRepository<Airport, Long> {

    Optional<Airport> findById(Long airportId);

    List<Airport> findAll();
}
