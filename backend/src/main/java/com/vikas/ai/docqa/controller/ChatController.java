package com.vikas.ai.docqa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ChatController {

    @Autowired
    private WebClient webClient;

    @PostMapping("/chat")
    public String chat(@RequestBody String query) {

        return webClient.post()
                .uri("http://localhost:8001/chat")
                .bodyValue(query)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}