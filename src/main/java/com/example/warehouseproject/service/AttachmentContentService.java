package com.example.warehouseproject.service;

import com.example.warehouseproject.domain.AttachmentContent;
import com.example.warehouseproject.repository.AttachmentContentRepository;
import com.example.warehouseproject.service.dto.AttachmentContentDTO;
import com.example.warehouseproject.service.mapper.AttachmentContentMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttachmentContentService {

    private final AttachmentContentRepository attachmentContentRepository;
    private final AttachmentContentMapper attachmentContentMapper;

    public AttachmentContentService(AttachmentContentRepository attachmentContentRepository, AttachmentContentMapper attachmentContentMapper) {
        this.attachmentContentRepository = attachmentContentRepository;
        this.attachmentContentMapper = attachmentContentMapper;
    }

    public AttachmentContentDTO save(AttachmentContentDTO attachmentContentDTO) {
        AttachmentContent attachmentContent = attachmentContentMapper.toEntity(attachmentContentDTO);
        attachmentContent = attachmentContentRepository.save(attachmentContent);
        return attachmentContentMapper.toDto(attachmentContent);
    }

    public AttachmentContentDTO update(AttachmentContentDTO attachmentContentDTO) {
        AttachmentContent attachmentContent = attachmentContentMapper.toEntity(attachmentContentDTO);
        attachmentContent = attachmentContentRepository.findAttachmentContentById(attachmentContent.getId());
        if (attachmentContent.getId() != null) {
            attachmentContent.setAttachment(attachmentContent.getAttachment());
            attachmentContent = attachmentContentRepository.save(attachmentContent);
            return attachmentContentMapper.toDto(attachmentContent);
        }
        return null;
    }

    public Page<AttachmentContentDTO> findAll(Pageable pageable) {
        return attachmentContentRepository.findAll(pageable).map(attachmentContentMapper::toDto);
    }

    public Optional<AttachmentContentDTO> findOne(Long id) {
        return attachmentContentRepository.findById(id).map(attachmentContentMapper::toDto);
    }

    public void delete(Long id) {
        attachmentContentRepository.deleteById(id);
    }
}
