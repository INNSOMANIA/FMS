package com.arsoftware.fms.company.persistence.db;

import com.arsoftware.fms.company.persistence.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository<T extends Company> extends JpaRepository<Company, Long> {

    Optional<Company> findById(Long companyId);

    List<Company> findAll();
}
