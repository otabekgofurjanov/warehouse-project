package com.example.warehouseproject.service.mapper;

import com.example.warehouseproject.domain.Attachment;
import com.example.warehouseproject.service.dto.AttachmentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface AttachmentMapper extends EntityMapper<AttachmentDTO, Attachment> {

    default Attachment fromId(Long id) {
        if (id == null) {
            return null;
        }

        Attachment attachment = new Attachment();
        attachment.setId(id);
        return attachment;
    }
}
