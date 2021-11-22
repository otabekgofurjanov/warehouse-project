package com.example.warehouseproject.domain;

import javax.persistence.*;

@Entity
public class AttachmentContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Byte bytes;

    @OneToOne
    private Attachment attachment;

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

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attechment) {
        this.attachment = attechment;
    }
}
