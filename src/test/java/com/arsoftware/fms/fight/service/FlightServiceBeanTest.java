package com.arsoftware.fms.fight.service;

import com.arsoftware.fms.fight.unit.FlightHelper;
import com.arsoftware.fms.flight.dto.FlightDTO;
import com.arsoftware.fms.flight.persistence.db.FlightRepository;
import com.arsoftware.fms.flight.persistence.entity.Flight;
import com.arsoftware.fms.flight.service.FlightServiceBean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FlightServiceBeanTest extends FlightHelper {

    @InjectMocks
    FlightServiceBean flightService;

    @Mock
    FlightRepository<Flight> flightRepository;

    @Test
    void getFlightTest() throws Exception {

        Flight flight = getSampleFlight();

        when(flightRepository.findById(anyLong())).thenReturn(Optional.of(flight));

        FlightDTO returnedFDTO = flightService.getFlight(anyLong());

        assertEquals(returnedFDTO.getId(), flight.getId());
        assertEquals(returnedFDTO.getCompanyId(), flight.getCompanyId());
        assertEquals(returnedFDTO.getPlaneId(), flight.getPlaneId());
    }

    @Test
    void getFlightThrowExcWhenFlightDoesNoExist() {
        when(flightRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));

        Exception exception = assertThrows(Exception.class, () -> {
            flightService.getFlight(anyLong());
        });

        String exceptedMessage = "Flight is not found in the system";
        String actualMessage = exception.getMessage();
    }

    @Test
    void getFlightListTest() {
        List<Flight> flightList = getSampleFlightList();

        when(flightRepository.findAll()).thenReturn(flightList);

        List<FlightDTO> flightDTOList = flightService.getFlightList();

        assertEquals(2, flightDTOList.size());
    }
}
