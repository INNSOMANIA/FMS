package com.arsoftware.fms.company.service;

import com.arsoftware.fms.company.dto.CompanyDTO;
import com.arsoftware.fms.company.persistence.db.CompanyRepository;
import com.arsoftware.fms.company.persistence.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServiceBean implements CompanyService {

    CompanyRepository<Company> companyRepository;

    @Override
    public CompanyDTO getCompany(long companyId) throws Exception {
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            return new CompanyDTO(company.getId(),
                    company.getName(),
                    company.getTaxNumber());
        } else {
            throw new Exception("Company is not found in the system");
        }
    }

    @Override
    public List<CompanyDTO> getCompanyList() {
        List<Company> companyList = companyRepository.findAll();
        return companyList.stream().map(company -> new CompanyDTO(
                        company.getId(),
                        company.getName(),
                        company.getTaxNumber()))
                .collect(Collectors.toList());
    }
}
