package com.vikas.ai.docqa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class FileController {

    @Autowired
    private WebClient webClient;

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {

        // 🔥 ADD THIS LINE HERE
        System.out.println("Uploading file: " + file.getOriginalFilename());

        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        builder.part("file", file.getResource());

        return webClient.post()
                .uri("http://localhost:8001/process")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .bodyValue(builder.build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}