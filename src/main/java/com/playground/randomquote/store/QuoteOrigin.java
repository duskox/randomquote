package com.playground.randomquote.store;

import com.playground.randomquote.store.dto.BreakingBadDto;
import lombok.Getter;

import java.util.function.Function;

public enum QuoteOrigin {
    //    RONSWANSON("Ron Swanson",
//            "https://ron-swanson-quotes.herokuapp.com/v2/quotes",
//            RonSwansonDto.class,
//            RonSwansonDto.toQuote
//            ),
    BREAKINGBAD("Breaking Bad",
            "https://breaking-bad-quotes.herokuapp.com/v1/quotes",
            BreakingBadDto.class,
            BreakingBadDto.toQuote);

    @Getter
    private final String name;
    @Getter
    private final String url;
    @Getter
    private final Class<?> dtoType;
    @Getter
    private final Function dtoToQuoteFunction;

    QuoteOrigin(String name,
                String url,
                Class<?> dtoType,
                Function dtoToQuoteFunction) {
        this.name = name;
        this.url = url;
        this.dtoType = dtoType;
        this.dtoToQuoteFunction = dtoToQuoteFunction;
    }

    public QuoteOrigin[] getAll() {
        return QuoteOrigin.values();
    }

}
