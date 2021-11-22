package com.example.warehouseproject.service.dto;

import com.sun.istack.NotNull;

public class CategoryDTO {

    private Long id;

    @NotNull
    private Long category_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}
