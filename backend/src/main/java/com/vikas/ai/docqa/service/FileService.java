package com.vikas.ai.docqa.service;

import com.vikas.ai.docqa.model.FileEntity;
import com.vikas.ai.docqa.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository repo;

    public FileEntity saveFile(MultipartFile file) {
        try {
            String path = "uploads/" + file.getOriginalFilename();

            Files.copy(file.getInputStream(), Paths.get(path));

            FileEntity entity = new FileEntity();
            entity.setFileName(file.getOriginalFilename());
            entity.setFileType(file.getContentType());
            entity.setFilePath(path);

            return repo.save(entity);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
