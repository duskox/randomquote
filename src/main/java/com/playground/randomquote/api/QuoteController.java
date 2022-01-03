package com.playground.randomquote.api;

import com.playground.randomquote.api.dto.QuoteDto;
import com.playground.randomquote.service.QuoteProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class QuoteController {

    private final QuoteProviderService quoteProviderService;

    @Autowired
    public QuoteController(QuoteProviderService quoteProviderService) {
        this.quoteProviderService = quoteProviderService;
    }

    @GetMapping("/quote")
    public Mono<QuoteDto> getQuote() {
        return quoteProviderService.getQuote();
    }
}
