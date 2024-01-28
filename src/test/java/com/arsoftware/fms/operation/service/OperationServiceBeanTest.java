package com.arsoftware.fms.operation.service;

import com.arsoftware.fms.operation.dto.OperationDTO;
import com.arsoftware.fms.operation.persistence.db.OperationRepository;
import com.arsoftware.fms.operation.persistence.persistence.Operation;
import com.arsoftware.fms.operation.unit.OperationHelper;
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
public class OperationServiceBeanTest extends OperationHelper {

    @InjectMocks
    OperationServiceBean operationService;

    @Mock
    OperationRepository<Operation> operationRepository;

    @Test
    void getOperationTest() throws Exception {

        Operation operation = getSampleOperation();

        when(operationRepository.findById(anyLong())).thenReturn(Optional.of(operation));

        OperationDTO returnedODTO = operationService.getOperation(anyLong());

        assertEquals(returnedODTO.getId(), operation.getId());
        assertEquals(returnedODTO.getAirportId(), operation.getAirportId());
        assertEquals(returnedODTO.getCompanyId(), operation.getCompanyId());
        assertEquals(returnedODTO.getCustomerId(), operation.getCustomerId());
        assertEquals(returnedODTO.getFightId(), operation.getFightId());
    }

    @Test
    void getOperationThrowExcWhenOperationDoesNoExist() {
        when(operationRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));

        Exception exception = assertThrows(Exception.class, () -> {
            operationService.getOperation(anyLong());
        });

        String exceptedMessage = "Operation is not found in the system";
        String actualMessage = exception.getMessage();
    }

    @Test
    void getOperationListTest() {
        List<Operation> operationList = getSampleOperationList();

        when(operationRepository.findAll()).thenReturn(operationList);

        List<OperationDTO> operationDTOList = operationService.getOperationList();

        assertEquals(2, operationDTOList.size());
    }
}
