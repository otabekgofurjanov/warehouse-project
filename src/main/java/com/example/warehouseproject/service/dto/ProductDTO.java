package com.example.warehouseproject.service.dto;

import com.sun.istack.NotNull;

public class ProductDTO {

    private Long id;

    @NotNull
    private String code;

    @NotNull
    private Long measurement_id;

    @NotNull
    private Long category_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getMeasurement_id() {
        return measurement_id;
    }

    public void setMeasurement_id(Long measurement_id) {
        this.measurement_id = measurement_id;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}
