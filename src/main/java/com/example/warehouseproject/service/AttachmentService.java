package com.example.warehouseproject.service;

import com.example.warehouseproject.domain.Attachment;
import com.example.warehouseproject.repository.AttachmentRepository;
import com.example.warehouseproject.service.dto.AttachmentDTO;
import com.example.warehouseproject.service.mapper.AttachmentMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final AttachmentMapper attachmentMapper;

    public AttachmentService(AttachmentRepository attachmentRepository, AttachmentMapper attachmentMapper) {
        this.attachmentRepository = attachmentRepository;
        this.attachmentMapper = attachmentMapper;
    }

    public AttachmentDTO save(AttachmentDTO attachmentDTO) {
        if (attachmentDTO.getId() == null) {
            Attachment attachment = attachmentMapper.toEntity(attachmentDTO);
            attachment = attachmentRepository.save(attachment);
            return attachmentMapper.toDto(attachment);
        }
        return null;
    }

    public AttachmentDTO update(AttachmentDTO attachmentDTO) {
        Attachment attachment = attachmentMapper.toEntity(attachmentDTO);
        attachment = attachmentRepository.findByAttachmentId(attachment.getId());
        if (attachment.getId() != null) {
            attachment.setName(attachment.getName());
            attachment = attachmentRepository.save(attachment);
            return attachmentMapper.toDto(attachment);
        }
        return null;
    }

    public Page<AttachmentDTO> findAll(Pageable pageable) {
        return attachmentRepository.findAll(pageable).map(attachmentMapper::toDto);
    }

    public Optional<AttachmentDTO> findOne(Long id) {
        if (id == null) {
            return null;
        }
        return attachmentRepository.findById(id).map(attachmentMapper::toDto);
    }

    public void delete(Long id) {
        attachmentRepository.deleteById(id);
    }
}
