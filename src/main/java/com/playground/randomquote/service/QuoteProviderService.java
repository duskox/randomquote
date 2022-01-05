package com.playground.randomquote.service;

import com.playground.randomquote.api.dto.QuoteDto;
import com.playground.randomquote.store.QuoteSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class QuoteProviderService {

    private final WebClient.Builder webClientBuilder;
    private final RandomnessService randomnessService;

    public QuoteProviderService(WebClient.Builder webClientBuilder,
                                RandomnessService randomnessService) {
        this.webClientBuilder = webClientBuilder;
        this.randomnessService = randomnessService;
    }

    public Mono<QuoteDto> getQuote() {
        var randomQuoteOrigin = getRandomQuoteOrigin();
        var webClient = webClientBuilder
                .baseUrl(randomQuoteOrigin.getUrl())
                .defaultHeaders(httpHeaders -> httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON)))
                .build();

        return webClient.get()
                .retrieve()
                .bodyToMono(randomQuoteOrigin.getDtoType())
                .map(randomQuoteOrigin.getDtoToQuoteFunction());
    }

    private QuoteSource getRandomQuoteOrigin() {
        return randomnessService.getRandomQuoteSource();
    }
}
