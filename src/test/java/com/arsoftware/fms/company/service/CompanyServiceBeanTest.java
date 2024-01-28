package com.arsoftware.fms.company.service;

import com.arsoftware.fms.company.dto.CompanyDTO;
import com.arsoftware.fms.company.persistence.db.CompanyRepository;
import com.arsoftware.fms.company.persistence.entity.Company;
import com.arsoftware.fms.company.unit.CompanyHelper;
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
@ExtendWith(MockitoExtension.class)
public class CompanyServiceBeanTest extends CompanyHelper {

    @InjectMocks
    CompanyServiceBean companyService;

    @Mock
    CompanyRepository<Company> companyRepository;

    @Test
    void getCompanyTest() throws Exception {

        Company company = getSampleCompany();

        when(companyRepository.findById(anyLong())).thenReturn(Optional.of(company));

        CompanyDTO returnedCDTO = companyService.getCompany(anyLong());

        assertEquals(returnedCDTO.getId(), company.getId());
        assertEquals(returnedCDTO.getName(), company.getName());
        assertEquals(returnedCDTO.getTaxNumber(), company.getTaxNumber());
    }

    @Test
    void getCompanyThrowExcWhenCompanyDoesNoExist() {

        when(companyRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));

        Exception exception = assertThrows(Exception.class, () -> {
            companyService.getCompany(anyLong());
        });

        String expectedMessage = "Company is not found in the system";
        String actualMessage = exception.getMessage();
    }

    @Test
    void getCompanyListTest() {

        List<Company> companyList = getSampleCompanyList();

        when(companyRepository.findAll()).thenReturn(companyList);

        List<CompanyDTO> companyDTOList = companyService.getCompanyList();

        assertEquals(2, companyDTOList.size());
    }
}
