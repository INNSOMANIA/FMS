package com.arsoftware.fms.customer.service;

import com.arsoftware.fms.customer.dto.CustomerDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerService {

    CustomerDTO getCustomer(long customerId) throws Exception;

    List<CustomerDTO> getCustomerList();
}
