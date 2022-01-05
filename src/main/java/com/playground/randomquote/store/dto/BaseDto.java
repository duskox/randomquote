package com.playground.randomquote.store.dto;

import com.playground.randomquote.api.dto.QuoteDto;

@FunctionalInterface
public interface BaseDto<T extends  BaseDto> {
    QuoteDto process(T t);
}
