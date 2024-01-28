package com.arsoftware.fms.flight.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "FLIGHT")
public class Flight {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "PLANE_ID", nullable = false)
    private Long planeId;

    @Column(name = "COMPANY_ID", nullable = false)
    private Long companyId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Long planeId) {
        this.planeId = planeId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
