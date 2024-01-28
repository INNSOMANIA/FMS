package com.arsoftware.fms.customer.controller;

import com.arsoftware.fms.customer.service.CustomerService;
import com.arsoftware.fms.customer.unit.CustomerHelper;
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
public class CustomerControllerTest extends CustomerHelper {

    @MockBean
    private CustomerService customerService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCustomer() throws Exception {

        when(customerService.getCustomer(1000L)).thenReturn(getSampleCustomerDTO());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customer/1000"))
                .andExpect(status().isOk())
                .equals(getSampleCustomerDTO());
    }

    @Test
    void getCustomerList() throws Exception {

        when(customerService.getCustomerList()).thenReturn(getSampleCustomerDTOList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customer"))
                .andExpect(status().isOk())
                .equals(getSampleCustomerDTOList());
    }

}
