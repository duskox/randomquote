package com.playground.randomquote.utils;

import com.playground.randomquote.store.dto.RonSwansonDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class CustomRonSwansonDeserializerTest {

    @Autowired
    JacksonTester<RonSwansonDto> jacksonTester;

    @Test
    void test() throws IOException {
        // given
        var jsonToTest = "[\"Very quoty quote\"]";

        // when
        var resultRonSwansonDto = jacksonTester.parseObject(jsonToTest);

        // then
        assertEquals("\"Very quoty quote\"", resultRonSwansonDto.getQuote());
    }
}