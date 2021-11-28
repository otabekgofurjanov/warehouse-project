package com.example.warehouseproject.service.mapper;

import com.example.warehouseproject.domain.AttachmentContent;
import com.example.warehouseproject.service.dto.AttachmentContentDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {AttachmentMapper.class})
public interface AttachmentContentMapper extends EntityMapper<AttachmentContentDTO, AttachmentContent> {

    @Mapping(source = "attachment.id", target = "attachment_id")
    AttachmentContentDTO toDto(AttachmentContent attachmentContent);

    @Mapping(source = "attachment_id", target = "attachment")
    AttachmentContent toEntity(AttachmentContentDTO attachmentContentDTO);


    default AttachmentContent fromId(Long id) {
        if (id == null) {
            return null;
        }

        AttachmentContent attachmentContent = new AttachmentContent();
        attachmentContent.setId(id);
        return attachmentContent;
    }
}
