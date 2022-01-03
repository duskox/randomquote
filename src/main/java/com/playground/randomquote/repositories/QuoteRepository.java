package com.playground.randomquote.repositories;

public interface QuoteRepository {
    Quote getQuote(int index);
    void storeQuote(Quote quote);
}
