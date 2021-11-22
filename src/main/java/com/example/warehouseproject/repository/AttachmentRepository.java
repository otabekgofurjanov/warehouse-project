package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    Attachment findByAttachmentId(@Param("id") Long id);
}
