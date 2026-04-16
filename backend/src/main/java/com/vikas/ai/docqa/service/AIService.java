package com.vikas.ai.docqa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AIService {

    private final WebClient webClient;

    public String ask(String question) {
        return webClient.post()
                .uri("/ask")
                .bodyValue(Map.of("question", question))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}