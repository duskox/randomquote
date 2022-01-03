package com.playground.randomquote.api.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class QuoteDto {
    String quote;
    String author;
}
