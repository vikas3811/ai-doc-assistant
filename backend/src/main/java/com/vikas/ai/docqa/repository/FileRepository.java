package com.vikas.ai.docqa.repository;

import com.vikas.ai.docqa.model.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
