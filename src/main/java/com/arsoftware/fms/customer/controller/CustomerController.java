package com.arsoftware.fms.customer.controller;

import com.arsoftware.fms.customer.dto.CustomerDTO;
import com.arsoftware.fms.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/{customerId}")
    public CustomerDTO getCustomer(@PathVariable("customerId") long customerId) throws Exception {
        return customerService.getCustomer(customerId);
    }

    @GetMapping(value = "")
    public List<CustomerDTO> getCustomerList() {
        return customerService.getCustomerList();
    }

}
