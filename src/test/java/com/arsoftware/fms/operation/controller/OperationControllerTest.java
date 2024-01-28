package com.arsoftware.fms.operation.controller;

import com.arsoftware.fms.operation.service.OperationService;
import com.arsoftware.fms.operation.unit.OperationHelper;
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
public class OperationControllerTest extends OperationHelper {

    @MockBean
    private OperationService operationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getOperation() throws Exception {

        when(operationService.getOperation(1000L)).thenReturn(getSampleOperationDTO());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/operation/1000"))
                .andExpect(status().isOk())
                .equals(getSampleOperationDTO());
    }

    @Test
    void getOperationList() throws Exception {

        when(operationService.getOperationList()).thenReturn(getSampleOperationDTOList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/operation"))
                .andExpect(status().isOk())
                .equals(getSampleOperationDTOList());
    }
}
