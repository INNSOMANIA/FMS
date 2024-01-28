package com.arsoftware.fms.flight.dto;

import java.io.Serial;
import java.io.Serializable;

public class FlightDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 111L;

    private final long id;

    private final Long planeId;

    private final Long companyId;

    public FlightDTO(long id, Long planeId, Long companyId) {
        this.id = id;
        this.planeId = planeId;
        this.companyId = companyId;
    }

    public long getId() {
        return id;
    }

    public Long getPlaneId() {
        return planeId;
    }

    public Long getCompanyId() {
        return companyId;
    }
}
