package com.example.warehouseproject.domain;

import com.example.warehouseproject.domain.ext.FieldEntity;

import javax.persistence.Entity;

@Entity
public class Currency extends FieldEntity {

    private Boolean active = false;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
