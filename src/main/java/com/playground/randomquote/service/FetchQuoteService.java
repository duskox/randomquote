package com.playground.randomquote.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class FetchQuoteService {

    private final WebClient webClient;

    public FetchQuoteService(WebClient.Builder webClientBuilder) {
        webClient = webClientBuilder
                .baseUrl("some URL")
                .defaultHeaders(httpHeaders -> httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON)))
                .build();
    }

    public Mono<String> fetchQuote() {

    }
}
