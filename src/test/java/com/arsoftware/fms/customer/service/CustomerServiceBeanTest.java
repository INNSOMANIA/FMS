package com.arsoftware.fms.customer.service;

import com.arsoftware.fms.customer.dto.CustomerDTO;
import com.arsoftware.fms.customer.persistence.cb.CustomerRepository;
import com.arsoftware.fms.customer.persistence.entity.Customer;
import com.arsoftware.fms.customer.unit.CustomerHelper;
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
@ExtendWith({MockitoExtension.class})
public class CustomerServiceBeanTest extends CustomerHelper {

    @InjectMocks
    CustomerServiceBean customerService;

    @Mock
    CustomerRepository<Customer> customerRepository;

    @Test
    void getCustomerTest() throws Exception {

        Customer customer = getSampleCustomer();

        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));

        CustomerDTO returnedCDTO = customerService.getCustomer(anyLong());

        assertEquals(returnedCDTO.getId(), customer.getId());
        assertEquals(returnedCDTO.getName(), customer.getName());
        assertEquals(returnedCDTO.getSurname(), customer.getSurname());
        assertEquals(returnedCDTO.getAge(), customer.getAge());
    }

    @Test
    void getCustomerThrowExcWhenCustomerDoesNoExist() {
        when(customerRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));

        Exception exception = assertThrows(Exception.class, () -> {
            customerService.getCustomer(anyLong());
        });

        String exceptedMessage = "Customer is not found in the system";
        String actualMessage = exception.getMessage();
    }

    @Test
    void getCustomerListTest() {
        List<Customer> customerList = getSampleCustomerList();

        when(customerRepository.findAll()).thenReturn(customerList);

        List<CustomerDTO> customerDTOList = customerService.getCustomerList();

        assertEquals(2, customerDTOList.size());
    }
}
