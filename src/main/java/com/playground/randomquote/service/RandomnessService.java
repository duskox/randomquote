package com.playground.randomquote.service;

import com.playground.randomquote.store.QuoteSource;
import com.playground.randomquote.store.SourcesStore;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomnessService {

    private final Random random;
    private final SourcesStore sourcesStore;

    public RandomnessService(SourcesStore sourcesStore) {
        random = new Random();
        this.sourcesStore =sourcesStore;
    }

    public QuoteSource getRandomQuoteOrigin() {
        var index = random.nextInt(sourcesStore.quoteSources.size());
        return sourcesStore.quoteSources.get(index);
    }
}