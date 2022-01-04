package com.playground.randomquote.config;

import lombok.Builder;
import lombok.Value;

import java.util.Map;

@Value
@Builder(toBuilder = true)
public class ErrorDto {
    String failureReason;
    Map<String, String> details;
}
