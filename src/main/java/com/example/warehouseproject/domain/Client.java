package com.example.warehouseproject.domain;

import com.example.warehouseproject.domain.ext.FieldEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Client extends FieldEntity {

    @Column(nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
