package com.playground.randomquote.store;

import com.playground.randomquote.store.dto.BaseDto;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class QuoteSource {
    String name;
    String url;
    Class<? extends BaseDto> dtoType;
}
