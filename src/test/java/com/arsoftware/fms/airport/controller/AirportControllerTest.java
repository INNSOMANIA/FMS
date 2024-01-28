package com.arsoftware.fms.airport.controller;

import com.arsoftware.fms.airport.service.AirportService;
import com.arsoftware.fms.airport.unit.AirportHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AirportControllerTest extends AirportHelper {

    @MockBean
    private AirportService airportService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAirport() throws Exception {

        when(airportService.getAirport(1000L)).thenReturn(getSampleAirportDTO());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/airport/1000"))
                .andExpect(status().isOk())
                .equals(getSampleAirportDTO());
    }

    @Test
    void getAirportList() throws Exception {
        when(airportService.getAirportList()).thenReturn(getSampleAirportDTOList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/airport"))
                .andExpect(status().isOk())
                .equals(getSampleAirportDTOList());
    }
}
