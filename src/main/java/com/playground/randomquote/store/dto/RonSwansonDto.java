package com.playground.randomquote.store.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.playground.randomquote.api.dto.QuoteDto;
import com.playground.randomquote.utils.CustomRonSwansonDeserializer;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@JsonDeserialize(using = CustomRonSwansonDeserializer.class)
public class RonSwansonDto implements BaseDto<RonSwansonDto> {

    String quote;

    @Override
    public QuoteDto process(RonSwansonDto ronSwansonDto) {
        return QuoteDto
                .builder()
                .quote(ronSwansonDto.getQuote())
                .author("Ron Swanson")
                .build();
    }
}
