package com.arsoftware.fms.customer.dto;

import java.io.Serial;
import java.io.Serializable;

public class CustomerDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 111L;

    private final long id;

    private final String name;

    private final String surname;

    private final int age;

    public CustomerDTO(long id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }
}
