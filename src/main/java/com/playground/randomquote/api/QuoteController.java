package com.playground.randomquote.api;

import com.playground.randomquote.api.dto.QuoteDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class QuoteController {

    @GetMapping("/quote")
    public Mono<QuoteDto> getQuote() {
        return Mono.just(QuoteDto
                .builder()
                .quote("some quote")
                .build());
    }
}
