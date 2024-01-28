package com.arsoftware.fms.airport.dto;

import java.io.Serial;
import java.io.Serializable;

public class AirportDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 111L;

    private final long id;

    private final String name;

    public AirportDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
