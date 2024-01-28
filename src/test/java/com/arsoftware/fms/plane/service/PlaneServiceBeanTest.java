package com.arsoftware.fms.plane.service;

import com.arsoftware.fms.plane.dto.PlaneDTO;
import com.arsoftware.fms.plane.persistens.db.PlaneRepository;
import com.arsoftware.fms.plane.persistens.entity.Plane;
import com.arsoftware.fms.plane.unit.PlaneHelper;
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
public class PlaneServiceBeanTest extends PlaneHelper {

    @InjectMocks
    PlaneServiceBean planeService;

    @Mock
    PlaneRepository<Plane> planeRepository;

    @Test
    void getPlaneTest() throws Exception {

        Plane plane = getSamplePlane();

        when(planeRepository.findById(anyLong())).thenReturn(Optional.of(plane));

        PlaneDTO returnedPDTO = planeService.getPlane(anyLong());

        assertEquals(returnedPDTO.getId(), plane.getId());
        assertEquals(returnedPDTO.getMake(), plane.getMake());
        assertEquals(returnedPDTO.getModel(), plane.getModel());
        assertEquals(returnedPDTO.getCompanyId(), plane.getCompanyId());
        assertEquals(returnedPDTO.getCaptainPilot(), plane.getCaptainPilot());
        assertEquals(returnedPDTO.getCoPilot(), plane.getCoPilot());
    }

    @Test
    void getPlaneThrowExcWhenPlaneDoesNoExist() {
        when(planeRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));

        Exception exception = assertThrows(Exception.class, () -> {
            planeService.getPlane(anyLong());
        });

        String exceptedMessage = "Plane is not found in the system";
        String actualMessage = exception.getMessage();
    }

    @Test
    void getPlaneListTest() {
        List<Plane> planeList = getSamplePLaneList();

        when(planeRepository.findAll()).thenReturn(planeList);

        List<PlaneDTO> planeDTOList = planeService.getPlaneList();

        assertEquals(2, planeDTOList.size());
    }
}
