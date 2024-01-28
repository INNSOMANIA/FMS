package com.arsoftware.fms.company.unit;

import com.arsoftware.fms.company.dto.CompanyDTO;
import com.arsoftware.fms.company.persistence.entity.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyHelper {

    protected static Company getSampleCompany() {
        Company company = new Company();
        company.setId(1000L);
        company.setName("NAME");
        company.setTaxNumber(2136763274);

        return company;
    }

    protected static List<Company> getSampleCompanyList() {
        List<Company> companyList = new ArrayList<>();
        companyList.add(getSampleCompany());
        companyList.add(getSampleCompany());

        return companyList;
    }

    protected static CompanyDTO getSampleCompanyDTO() {
        return new CompanyDTO(1L,
                "NAME",
                1231231412);
    }

    protected static List<CompanyDTO> getSampleCompanyDTOList() {
        List<CompanyDTO> companyDTOList = new ArrayList<>();
        companyDTOList.add(new CompanyDTO(1L,
                "NAME",
                2136763274));

        return companyDTOList;
    }
}
