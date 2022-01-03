package com.playground.randomquote.repositories;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryQuoteRepository implements QuoteRepository {
    private List<Quote> quotesList = new ArrayList<>();

    @Override
    public Quote getQuote(int index) {
        return quotesList.get(index);
    }

    @Override
    public void storeQuote(Quote quote) {
        quotesList.add(quote);
    }
}
