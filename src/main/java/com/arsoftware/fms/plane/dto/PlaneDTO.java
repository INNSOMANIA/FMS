package com.arsoftware.fms.plane.dto;

import java.io.Serial;
import java.io.Serializable;

public class PlaneDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 111L;

    private final long id;

    private final String make;

    private final String model;

    private final Long companyId;

    private final String captainPilot;

    private final String coPilot;

    public PlaneDTO(long id, String make, String model, Long companyId, String captainPilot, String coPilot) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.companyId = companyId;
        this.captainPilot = captainPilot;
        this.coPilot = coPilot;
    }

    public long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public String getCaptainPilot() {
        return captainPilot;
    }

    public String getCoPilot() {
        return coPilot;
    }
}
