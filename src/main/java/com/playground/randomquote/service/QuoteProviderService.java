package com.playground.randomquote.service;

import com.playground.randomquote.api.dto.QuoteDto;
import com.playground.randomquote.store.QuoteOrigin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class QuoteProviderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuoteProviderService.class);

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

        LOGGER.info("----->>> quote origin:{}", randomQuoteOrigin.getName());

        return webClient.get()
                .retrieve()
                .bodyToMono(randomQuoteOrigin.getDtoType())
                .map(o -> {
                    LOGGER.info("----->>> 01 object:{}", o);
                    return o;
                })
                .map(randomQuoteOrigin.getDtoToQuoteFunction())
                .map(o -> {
                    LOGGER.info("----->>> 02 object:{}", o);
                    return o;
                });
    }

    private QuoteOrigin getRandomQuoteOrigin() {
        var list = Arrays.asList(QuoteOrigin.values());
        return list.get(randomnessService.getRandom(list.size()));
    }

}
