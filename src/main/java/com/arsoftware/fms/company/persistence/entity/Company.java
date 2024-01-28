package com.arsoftware.fms.company.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "TAX_NUMBER", nullable = false)
    private int taxNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(int taxNumber) {
        this.taxNumber = taxNumber;
    }
}
