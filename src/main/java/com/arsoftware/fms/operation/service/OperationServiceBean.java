package com.arsoftware.fms.operation.service;

import com.arsoftware.fms.operation.dto.OperationDTO;
import com.arsoftware.fms.operation.persistence.db.OperationRepository;
import com.arsoftware.fms.operation.persistence.persistence.Operation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OperationServiceBean implements OperationService {

    OperationRepository<Operation> operationRepository;

    @Override
    public OperationDTO getOperation(long operationId) throws Exception {
        Optional<Operation> operationOptional = operationRepository.findById(operationId);
        if (operationOptional.isPresent()) {
            Operation operation = operationOptional.get();
            return new OperationDTO(operation.getId(),
                    operation.getCompanyId(),
                    operation.getCustomerId(),
                    operation.getAirportId(),
                    operation.getFightId());
        } else {
            throw new Exception("Operation is not found in the system");
        }
    }

    @Override
    public List<OperationDTO> getOperationList() {
        List<Operation> operationList = operationRepository.findAll();
        return operationList.stream().map(operation -> new OperationDTO(
                        operation.getId(),
                        operation.getCompanyId(),
                        operation.getCustomerId(),
                        operation.getAirportId(),
                        operation.getFightId()))
                .collect(Collectors.toList());

    }
}
