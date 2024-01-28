package com.arsoftware.fms.airport.controller;

import com.arsoftware.fms.airport.dto.AirportDTO;
import com.arsoftware.fms.airport.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/airport")
public class AirportController {

    @Autowired
    AirportService airportService;

    @GetMapping(value = "/{airportId}")
    public AirportDTO getAirport(@PathVariable("airportId") long airportId) throws Exception {
        return airportService.getAirport(airportId);
    }

    @GetMapping(value = "")
    public List<AirportDTO> getAirportList() {
        return airportService.getAirportList();
    }
}
