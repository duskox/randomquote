package com.playground.randomquote.config;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class ErrorDto {
    String failureReason;
}
