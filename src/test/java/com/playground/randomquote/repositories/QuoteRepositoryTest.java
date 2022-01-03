package com.playground.randomquote.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuoteRepositoryTest {

    private static final String TEST_QUOTE = "test quote";
    private static final String TEST_AUTHOR = "test author";

    QuoteRepository quoteRepository;

    @BeforeEach
    void setUp() {
        quoteRepository = new InMemoryQuoteRepository();
    }

    @Test
    void givenValidIndex_whenGettingQuote_thenReturnWantedQuote() {
        // given
        var quote1 = Quote
                .builder()
                .quote(TEST_QUOTE + "1")
                .author(TEST_AUTHOR)
                .build();

        var quote2 = Quote
                .builder()
                .quote(TEST_QUOTE + "2")
                .author(TEST_AUTHOR)
                .build();

        quoteRepository.storeQuote(quote1);
        quoteRepository.storeQuote(quote2);

        // when
        var result = quoteRepository.getQuote(1);

        // then
        assertEquals(quote2, result);
    }
}