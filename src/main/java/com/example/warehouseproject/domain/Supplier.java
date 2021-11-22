package com.example.warehouseproject.domain;

import com.example.warehouseproject.domain.ext.FieldEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Supplier extends FieldEntity {

    private Boolean active = false;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
