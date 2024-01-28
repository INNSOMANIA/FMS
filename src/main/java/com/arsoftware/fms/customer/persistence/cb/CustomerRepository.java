package com.arsoftware.fms.customer.persistence.cb;

import com.arsoftware.fms.customer.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository<T extends Customer> extends JpaRepository<Customer, Long> {

    Optional<Customer> findById(Long customerId);

    List<Customer> findAll();
}
