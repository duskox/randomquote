package com.playground.randomquote.utils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.playground.randomquote.store.dto.RonSwansonDto;

import java.io.IOException;

public class CustomRonSwansonDeserializer extends JsonDeserializer<RonSwansonDto> {

    @Override
    public RonSwansonDto deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        var treeNode = p.getCodec().readTree(p);
        var quote = treeNode.get(0);

        return RonSwansonDto
                .builder()
                .quote(quote.toString())
                .build();
    }
}
