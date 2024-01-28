package com.arsoftware.fms.airport.service;

import com.arsoftware.fms.airport.dto.AirportDTO;
import com.arsoftware.fms.airport.persistence.db.AirportRepository;
import com.arsoftware.fms.airport.persistence.entity.Airport;
import com.arsoftware.fms.airport.unit.AirportHelper;
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
public class AirportServiceBeanTest extends AirportHelper {

    @InjectMocks
    private AirportServiceBean airportService;

    @Mock
    AirportRepository<Airport> airportRepository;

    @Test
    void getAirportTest() throws Exception {
        Airport airport = getSampleAirport();

        when(airportRepository.findById(anyLong())).thenReturn(Optional.of(airport));

        AirportDTO returnedADTO = airportService.getAirport(anyLong());

        assertEquals(returnedADTO.getId(), airport.getId());
        assertEquals(returnedADTO.getName(), airport.getName());
    }

    @Test
    void getAirportThrowExcWhenAirportDoesNoExist() {
        when(airportRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));

        Exception exception = assertThrows(Exception.class, () -> {
            airportService.getAirport(anyLong());
        });

        String expectedMessage = "Airport is not found in the system";
        String actualMessage = exception.getMessage();
    }

    @Test
    void getAirportListTest() {
        List<Airport> airportList = getSampleAirportList();

        when(airportRepository.findAll()).thenReturn(airportList);

        List<AirportDTO> airportDTOList = airportService.getAirportList();

        assertEquals(2, airportDTOList.size());
    }
}
