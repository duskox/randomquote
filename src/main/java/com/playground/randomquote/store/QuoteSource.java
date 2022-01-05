package com.playground.randomquote.store;

import lombok.Builder;
import lombok.Value;

import java.util.function.Function;

@Value
@Builder
public class QuoteSource {
    String name;
    String url;
    Class<?> dtoType;
    Function dtoToQuoteFunction;
}
