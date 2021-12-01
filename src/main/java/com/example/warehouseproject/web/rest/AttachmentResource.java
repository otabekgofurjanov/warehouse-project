package com.example.warehouseproject.web.rest;

import com.example.warehouseproject.domain.Attachment;
import com.example.warehouseproject.result.Result;
import com.example.warehouseproject.service.AttachmentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.Option;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AttachmentResource {

    private final AttachmentService attachmentService;
    private final Result result;

    public AttachmentResource(AttachmentService attachmentService, Result result) {
        this.attachmentService = attachmentService;
        this.result = result;
    }

    @PostMapping("/upload")
    public Result uploadFile(MultipartHttpServletRequest request) {
        return attachmentService.addAttachment(request);
    }

    @GetMapping("/info")
    public List<Attachment> getAll() {
        return attachmentService.getAll();
    }

    @GetMapping("/info/{id}")
    public Attachment getById(@PathVariable Long id) {
        return attachmentService.getId(id);
    }

    @GetMapping("/download/{id}")
    public void downloadFile(@PathVariable Long id, HttpServletResponse response) {
        attachmentService.downloadFile(id, response);
    }
}
