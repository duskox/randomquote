package com.playground.randomquote.repositories;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
class QuoteRepositoryTest {

    private static final String TEST_QUOTE = "test quote";
    private static final String TEST_AUTHOR = "test author";

    @Parameterized.Parameter(value = 0)
    public QuoteRepository quoteRepository;

//    private QuoteRepository quoteRepository;

    @Parameterized.Parameters
    public static Collection<Object[]> instancesBeingTested() {
        Object[] data = new Object[] {
                new InMemoryQuoteRepository()
        };

        var data2 = Arrays.asList(data);
        var data3 = Collections.singletonList(data);

        return data3;

    }

    public QuoteRepositoryTest(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

//    @Parameterized.Parameters
//    public static Collection<Object[]> instancesBeingTested() {
//        return (Collection<Object[]>) Arrays.asList(new Object[]{
//                new InMemoryQuoteRepository(),
//                new InMemoryQuoteRepository()
//        });
//    }

//    @BeforeEach
//    void setUp() {
//        quoteRepository = new InMemoryQuoteRepository();
//    }

    @Test
//    @ParameterizedTest
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