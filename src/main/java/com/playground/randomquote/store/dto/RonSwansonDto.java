package com.playground.randomquote.store.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.playground.randomquote.repositories.Quote;
import com.playground.randomquote.utils.CustomRonSwansonDeserializer;
import lombok.Builder;
import lombok.Value;

import java.util.function.Function;

@Value
@Builder(toBuilder = true)
@JsonDeserialize(using = CustomRonSwansonDeserializer.class)
public class RonSwansonDto {

    String quote;

    public static Function<RonSwansonDto, Quote> toQuote = ronSwansonDto -> Quote
            .builder()
            .quote(ronSwansonDto.getQuote())
            .author("Ron Swanson")
            .build();
}
