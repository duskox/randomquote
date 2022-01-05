package com.playground.randomquote.store;

import com.playground.randomquote.store.dto.BreakingBadDto;
import com.playground.randomquote.store.dto.RonSwansonDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SourcesStore {

    public List<QuoteSource> quoteSources;

    public SourcesStore() {
        quoteSources = new ArrayList<>();

        var source1 = new QuoteSource(
                "Ron Swanson",
                "https://ron-swanson-quotes.herokuapp.com/v2/quotes",
                RonSwansonDto.class
        );

        var source2 = new QuoteSource(
                "Breaking Bad",
                "https://breaking-bad-quotes.herokuapp.com/v1/quotes",
                BreakingBadDto.class
        );

        quoteSources.add(source1);
        quoteSources.add(source2);
    }
}
