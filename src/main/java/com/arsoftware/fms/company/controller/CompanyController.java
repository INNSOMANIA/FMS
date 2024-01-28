package com.arsoftware.fms.company.controller;

import com.arsoftware.fms.company.dto.CompanyDTO;
import com.arsoftware.fms.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping(value = "/{companyId}")
    public CompanyDTO getCompany(@PathVariable("companyId") long companyId) throws Exception {
        return companyService.getCompany(companyId);
    }

    @GetMapping(value = "")
    public List<CompanyDTO> getCompanyList() {
        return companyService.getCompanyList();
    }
}
