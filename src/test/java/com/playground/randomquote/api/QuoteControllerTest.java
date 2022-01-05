package com.playground.randomquote.api;

import com.playground.randomquote.api.dto.QuoteDto;
import com.playground.randomquote.config.ErrorDto;
import com.playground.randomquote.service.QuoteProviderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.BDDMockito.given;

@WebFluxTest(value = QuoteController.class)
class QuoteControllerTest {

    @Autowired
    WebTestClient client;

    @MockBean
    QuoteProviderService quoteProviderService;

    @Test
    void givenValidApiCall_whenExpectedDtoReturned_thenValidate() {

        var quoteDto = QuoteDto
                .builder()
                .quote("quote")
                .author("author")
                .build();

        given(quoteProviderService.getQuote())
                .willReturn(Mono.just(quoteDto));

        client.get()
                .uri("/quote")
                .exchange()
                .expectBody(QuoteDto.class)
                .isEqualTo(quoteDto);
    }

    @Test
    void givenRuntimeException_whenGettingQuote_thenValidateError() {
        given(quoteProviderService.getQuote())
                .willThrow(new RuntimeException());

        client.get()
                .uri("/quote")
                .exchange()
                .expectStatus()
                .is5xxServerError()
                .expectBody(ErrorDto.class);
    }
}