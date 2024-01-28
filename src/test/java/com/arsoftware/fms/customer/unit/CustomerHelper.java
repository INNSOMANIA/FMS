package com.arsoftware.fms.customer.unit;

import com.arsoftware.fms.customer.dto.CustomerDTO;
import com.arsoftware.fms.customer.persistence.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerHelper {

    protected static Customer getSampleCustomer() {
        Customer customer = new Customer();
        customer.setId(1000L);
        customer.setName("NAME");
        customer.setSurname("SURNAME");
        customer.setAge(23);

        return customer;
    }

    protected static List<Customer> getSampleCustomerList() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(getSampleCustomer());
        customerList.add(getSampleCustomer());

        return customerList;
    }

    protected static CustomerDTO getSampleCustomerDTO() {
        return new CustomerDTO(1L,
                "NAME",
                "SURNAME",
                23);
    }

    protected static List<CustomerDTO> getSampleCustomerDTOList() {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        customerDTOList.add(new CustomerDTO(1L,
                "NAME",
                "SURNAME",
                23));

        return customerDTOList;
    }

}
