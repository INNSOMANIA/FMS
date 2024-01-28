package com.arsoftware.fms.company.service;

import com.arsoftware.fms.company.dto.CompanyDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CompanyService {

    CompanyDTO getCompany(long companyId) throws Exception;

    List<CompanyDTO> getCompanyList();

}
