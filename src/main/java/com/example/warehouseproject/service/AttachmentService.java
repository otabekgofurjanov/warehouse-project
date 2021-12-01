package com.example.warehouseproject.service;


import com.example.warehouseproject.domain.Attachment;
import com.example.warehouseproject.domain.AttachmentContent;
import com.example.warehouseproject.repository.AttachmentContentRepository;
import com.example.warehouseproject.repository.AttachmentRepository;
import com.example.warehouseproject.result.Result;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    private final Result result;
    private final AttachmentRepository attachmentRepository;
    private final AttachmentContentRepository attachmentContentRepository;


    public AttachmentService(Result result, AttachmentRepository attachmentRepository, AttachmentContentRepository attachmentContentRepository) {
        this.result = result;
        this.attachmentRepository = attachmentRepository;
        this.attachmentContentRepository = attachmentContentRepository;
    }

    public Result addAttachment(MultipartHttpServletRequest request) {
        Iterator<String> fileName = request.getFileNames();
        MultipartFile file = request.getFile(fileName.next());

        if (file == null) {
            result.setMessage("File is null");
            result.setSuccess(false);
            return result;
        }

        Attachment attachment = new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setContentType(file.getContentType());
        attachment.setSize((double) file.getSize());
        Attachment savedAttachment = attachmentRepository.save(attachment);

        AttachmentContent attachmentContent = new AttachmentContent();
        try {
            attachmentContent.setAttachment(savedAttachment);
            attachmentContent.setBytes(file.getBytes());
            attachmentContentRepository.save(attachmentContent);
        } catch (IOException e) {
            result.setMessage("File is empty");
            result.setSuccess(false);
            return result;
        }

        result.setMessage("File succesfully saved");
        result.setSuccess(true);
        return result;
    }

    public List<Attachment> getAll() {
        return attachmentRepository.findAll();
    }

    public Attachment getId(Long id) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (!optionalAttachment.isPresent()) {
            return null;
        }
        return optionalAttachment.get();
    }

    public void downloadFile(Long id, HttpServletResponse response) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            AttachmentContent attachmentContent = attachmentContentRepository.findByAttachment_Id(id);
            Attachment attachment = optionalAttachment.get();

            response.setHeader("Content-Disposition", "attachment; filename=\"" + attachment.getName() + "\"");
            response.setContentType(attachment.getContentType());

            try {
                FileCopyUtils.copy(attachmentContent.getBytes(), response.getOutputStream());
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

}
