package com.example.warehouseproject.service.dto;

import com.sun.istack.NotNull;

public class AttachmentDTO {

    private Long id;

    @NotNull
    private String contentType;

    @NotNull
    private String name;

    @NotNull
    private Double size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
