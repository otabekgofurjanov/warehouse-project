package com.example.warehouseproject.service.dto;

import com.sun.istack.NotNull;

public class OutputProductDTO {

    private Long id;

    @NotNull
    private Long amount;

    @NotNull
    private Double price;

    @NotNull
    private Long output_id;

    @NotNull
    private Long product_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getOutput_id() {
        return output_id;
    }

    public void setOutput_id(Long output_id) {
        this.output_id = output_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
}
