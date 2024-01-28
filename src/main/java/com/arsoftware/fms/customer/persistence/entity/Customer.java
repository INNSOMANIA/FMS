package com.arsoftware.fms.customer.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @Column(name = "ID", insertable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME", insertable = false)
    private String name;

    @Column(name = "SURNAME", insertable = false)
    private String surname;

    @Column(name = "AGE", insertable = false)
    private int age;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
