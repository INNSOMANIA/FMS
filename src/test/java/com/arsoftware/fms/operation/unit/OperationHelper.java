package com.arsoftware.fms.operation.unit;

import com.arsoftware.fms.operation.dto.OperationDTO;
import com.arsoftware.fms.operation.persistence.persistence.Operation;

import java.util.ArrayList;
import java.util.List;

public class OperationHelper {

    protected static Operation getSampleOperation() {
        Operation operation = new Operation();
        operation.setId(1000L);
        operation.setCompanyId(1L);
        operation.setAirportId(1L);
        operation.setCustomerId(1L);
        operation.setFightId(1L);

        return operation;
    }

    protected static List<Operation> getSampleOperationList() {
        List<Operation> operationList = new ArrayList<>();
        operationList.add(getSampleOperation());
        operationList.add(getSampleOperation());

        return operationList;
    }

    protected static OperationDTO getSampleOperationDTO() {
        return new OperationDTO(1000L,
                1L,
                1L,
                1L,
                1L);
    }

    protected static List<OperationDTO> getSampleOperationDTOList() {
        List<OperationDTO> operationDTOList = new ArrayList<>();
        operationDTOList.add(new OperationDTO(1000L,
                1L,
                1L,
                1L,
                1L));

        return operationDTOList;
    }
}
