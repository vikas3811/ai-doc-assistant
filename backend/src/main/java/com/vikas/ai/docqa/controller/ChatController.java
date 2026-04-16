package com.vikas.ai.docqa.controller;

import com.vikas.ai.docqa.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

    private final AIService aiService;

    @PostMapping
    public ResponseEntity<?> chat(@RequestBody Map<String, String> req) {
        String question = req.get("question");
        return ResponseEntity.ok(aiService.ask(question));
    }
}
