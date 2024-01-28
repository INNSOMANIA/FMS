package com.arsoftware.fms.customer.service;

import com.arsoftware.fms.customer.dto.CustomerDTO;
import com.arsoftware.fms.customer.persistence.cb.CustomerRepository;
import com.arsoftware.fms.customer.persistence.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceBean implements CustomerService {

    CustomerRepository<Customer> customerRepository;


    @Override
    public CustomerDTO getCustomer(long customerId) throws Exception {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return new CustomerDTO(
                    customer.getId(),
                    customer.getName(),
                    customer.getSurname(),
                    customer.getAge());
        } else {
            throw new Exception("Customer is not found in the system");
        }
    }

    @Override
    public List<CustomerDTO> getCustomerList() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream().map(customer -> new CustomerDTO(
                        customer.getId(),
                        customer.getName(),
                        customer.getSurname(),
                        customer.getAge()))
                .collect(Collectors.toList());
    }
}
