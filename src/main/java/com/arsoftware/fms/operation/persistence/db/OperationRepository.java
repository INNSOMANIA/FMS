package com.arsoftware.fms.operation.persistence.db;

import com.arsoftware.fms.operation.persistence.persistence.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OperationRepository<T extends Operation> extends JpaRepository<Operation, Long> {

    Optional<Operation> findById(long operationId);

    List<Operation> findAll();
}
