package com.example.warehouseproject.domain;

import com.example.warehouseproject.domain.ext.FieldEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Category extends FieldEntity {

    private boolean active = false;

    @ManyToOne
    Category category;

    public Boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
