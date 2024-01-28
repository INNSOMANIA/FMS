package com.arsoftware.fms.fight.controller;

import com.arsoftware.fms.fight.unit.FlightHelper;
import com.arsoftware.fms.flight.service.FlightService;
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
public class FlightControllerTest extends FlightHelper {

    @MockBean
    private FlightService flightService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getFlight() throws Exception {

        when(flightService.getFlight(1000L)).thenReturn(getSampleFlightDTO());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/flight/1000"))
                .andExpect(status().isOk())
                .equals(getSampleFlightDTO());
    }

    @Test
    void getFlightList() throws Exception {

        when(flightService.getFlightList()).thenReturn(getSampleFlightDTOList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/flight"))
                .andExpect(status().isOk())
                .equals(getSampleFlightDTOList());
    }
}
