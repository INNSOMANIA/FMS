package com.arsoftware.fms.operation.service;

import com.arsoftware.fms.operation.dto.OperationDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OperationService {

    OperationDTO getOperation(long operationId) throws Exception;

    List<OperationDTO> getOperationList();
}
