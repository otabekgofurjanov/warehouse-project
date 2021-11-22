package com.example.warehouseproject.service.dto;

import com.sun.istack.NotNull;

import java.util.Date;

public class AllProductDTO {

    private Long id;

    @NotNull
    private Long amount;

    private Date date;

    @NotNull
    private Long product_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
