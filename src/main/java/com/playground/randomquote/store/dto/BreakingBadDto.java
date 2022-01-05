package com.playground.randomquote.store.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.playground.randomquote.api.dto.QuoteDto;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@JsonPropertyOrder({
        "quote",
        "author"
})
public class BreakingBadDto extends ArrayList implements BaseDto<BreakingBadDto> {

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

    @Override
    public QuoteDto process(BreakingBadDto breakingBadDto) {
        return QuoteDto
                .builder()
                .quote((String) ((LinkedHashMap) breakingBadDto.get(0)).get("quote"))
                .author((String) ((LinkedHashMap) breakingBadDto.get(0)).get("author"))
                .build();
    }
}
