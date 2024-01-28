package com.arsoftware.fms.company.dto;

import java.io.Serial;
import java.io.Serializable;

public class CompanyDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 111L;

    private final long id;

    private final String name;

    private final int taxNumber;

    public CompanyDTO(long id, String name, int taxNumber) {
        this.id = id;
        this.name = name;
        this.taxNumber = taxNumber;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTaxNumber() {
        return taxNumber;
    }
}
