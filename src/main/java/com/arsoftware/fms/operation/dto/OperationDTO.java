package com.arsoftware.fms.operation.dto;

import java.io.Serial;
import java.io.Serializable;

public class OperationDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 111L;

    private final long id;

    private final Long companyId;

    private final Long customerId;

    private final Long airportId;

    private final Long fightId;

    public OperationDTO(long id, Long companyId, Long customerId, Long airportId, Long fightId) {
        this.id = id;
        this.companyId = companyId;
        this.customerId = customerId;
        this.airportId = airportId;
        this.fightId = fightId;
    }

    public long getId() {
        return id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getAirportId() {
        return airportId;
    }

    public Long getFightId() {
        return fightId;
    }
}
