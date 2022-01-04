package com.playground.randomquote.store.dto;

import com.fasterxml.jackson.annotation.*;
import com.playground.randomquote.repositories.Quote;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.function.Function;

@JsonPropertyOrder({
        "quote",
        "author"
})
public class BreakingBadDto extends ArrayList {

    @JsonProperty("quote")
    private String quote;
    @JsonProperty("author")
    private String author;

    @JsonProperty("quote")
    public String getQuote() {
        return quote;
    }

    @JsonProperty("quote")
    public void setQuote(String quote) {
        this.quote = quote;
    }

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    public static Function<BreakingBadDto, Quote> toQuote = breakingBadDto -> {
        var quote = Quote
                .builder()
                .quote((String) ((LinkedHashMap) breakingBadDto.get(0)).get("quote"))
                .author((String) ((LinkedHashMap) breakingBadDto.get(0)).get("author"))
                .build();

        return quote;
    };
}
