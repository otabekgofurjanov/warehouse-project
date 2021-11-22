package com.example.warehouseproject.service.dto;

import com.sun.istack.NotNull;

public class AttachmentContentDTO {

    private Long id;

    @NotNull
    private Byte bytes;

    @NotNull
    private Long attachment_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getBytes() {
        return bytes;
    }

    public void setBytes(Byte bytes) {
        this.bytes = bytes;
    }

    public Long getAttachment_id() {
        return attachment_id;
    }

    public void setAttachment_id(Long attachment_id) {
        this.attachment_id = attachment_id;
    }
}
