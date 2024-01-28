package com.arsoftware.fms.plane.controller;

import com.arsoftware.fms.plane.service.PlaneService;
import com.arsoftware.fms.plane.unit.PlaneHelper;
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
public class PlaneControllerTest extends PlaneHelper {

    @MockBean
    private PlaneService planeService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getPlane() throws Exception {

        when(planeService.getPlane(1000L)).thenReturn(getSamplePlaneDTO());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/plane/1000"))
                .andExpect(status().isOk())
                .equals(getSamplePlaneDTO());
    }

    @Test
    void getPlaneList() throws Exception {

        when(planeService.getPlaneList()).thenReturn(getSamplePlaneDTOList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/plane"))
                .andExpect(status().isOk())
                .equals(getSamplePlaneDTOList());
    }
}
