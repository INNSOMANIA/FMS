package com.arsoftware.fms.flight.persistence.db;

import com.arsoftware.fms.flight.persistence.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlightRepository<T extends Flight> extends JpaRepository<Flight, Long> {

    Optional<Flight> findById(long flight);

    List<Flight> findAll();
}
