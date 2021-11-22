package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Long> {

    AttachmentContent findByAttachmentContentId(@Param("id") Long id);
}
