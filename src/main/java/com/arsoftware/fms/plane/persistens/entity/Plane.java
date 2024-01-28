package com.arsoftware.fms.plane.persistens.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PLANE")
public class Plane {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "MAKE", nullable = false)
    private String make;

    @Column(name = "MODEL", nullable = false)
    private String model;

    @Column(name = "COMPANY_ID", nullable = false)
    private Long companyId;

    @Column(name = "CAPTAIN_PILOT", nullable = false)
    private String captainPilot;

    @Column(name = "CO_PILOT", nullable = false)
    private String coPilot;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCaptainPilot() {
        return captainPilot;
    }

    public void setCaptainPilot(String captainPilot) {
        this.captainPilot = captainPilot;
    }

    public String getCoPilot() {
        return coPilot;
    }

    public void setCoPilot(String coPilot) {
        this.coPilot = coPilot;
    }
}
