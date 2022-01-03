package com.playground.randomquote.repositories;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Quote {
    String quote;
    String author;
}
