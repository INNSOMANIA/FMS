package com.arsoftware.fms.flight.controller;

import com.arsoftware.fms.flight.dto.FlightDTO;
import com.arsoftware.fms.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/flight")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping(value = "/{flightId}")
    public FlightDTO getFlight(@PathVariable("flightId") long flightId) throws Exception {
        return flightService.getFlight(flightId);
    }

    @GetMapping(value = "")
    public List<FlightDTO> getFlightList() {
        return flightService.getFlightList();
    }
}
