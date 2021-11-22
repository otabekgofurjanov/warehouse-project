package com.example.warehouseproject.domain;


import com.example.warehouseproject.domain.ext.FieldEntity;

import javax.persistence.Entity;

@Entity
public class Measurement extends FieldEntity {

    private Boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
