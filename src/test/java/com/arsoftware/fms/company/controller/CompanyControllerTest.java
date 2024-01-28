package com.arsoftware.fms.company.controller;

import com.arsoftware.fms.company.service.CompanyService;
import com.arsoftware.fms.company.unit.CompanyHelper;
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
public class CompanyControllerTest extends CompanyHelper {

    @MockBean
    private CompanyService companyService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCompany() throws Exception {

        when(companyService.getCompany(1000L)).thenReturn(getSampleCompanyDTO());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/company/1000"))
                .andExpect(status().isOk())
                .equals(getSampleCompanyDTO());
    }

    @Test
    void getCompanyList() throws Exception {

        when(companyService.getCompanyList()).thenReturn(getSampleCompanyDTOList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/company"))
                .andExpect(status().isOk())
                .equals(getSampleCompanyDTOList());
    }
}
