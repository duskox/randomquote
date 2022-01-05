//package com.playground.randomquote.service;
//
//import com.playground.randomquote.api.dto.QuoteDto;
//import com.playground.randomquote.store.QuoteOrigin;
//import okhttp3.mockwebserver.MockResponse;
//import okhttp3.mockwebserver.MockWebServer;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.test.StepVerifier;
//
//import java.io.IOException;
//import java.util.function.Function;
//
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.doReturn;
//
//@RunWith(MockitoJUnitRunner.class)
//class QuoteProviderServiceTest {
//
//    QuoteProviderService quoteProviderService;
//
//    MockWebServer mockWebServer;
//    String testUrl;
//
//    @Mock
//    RandomnessService randomnessService;
//
//    @Mock
//    QuoteOrigin quoteOrigin;
//
//    @BeforeEach
//    void setUp() throws IOException {
//        MockitoAnnotations.openMocks(this);
//        mockWebServer = new MockWebServer();
//        mockWebServer.start();
//
//        var hostName = mockWebServer.getHostName();
//        var port = mockWebServer.getPort();
//        testUrl = String.format("http://%s:%o", hostName, port);
//
//        quoteProviderService = new QuoteProviderService(WebClient.builder(), randomnessService);
//    }
//
//    @AfterEach
//    void cleanUp() throws IOException {
//        mockWebServer.close();
//    }
//
//    @Test
//    void given_when_then() throws IOException {
//        // given
//        var testBody = "{\"line\":\"something\"}";
//        var mockResponse = new MockResponse()
//                .setResponseCode(200)
//                .setBody(testBody);
//        mockWebServer.enqueue(mockResponse);
//
//        var expected = QuoteDto
//                .builder()
//                .build();
//        Function<String, QuoteDto> mockFunction = s -> expected;
//
//        given(randomnessService.getRandomQuoteOrigin())
//                .willReturn(quoteOrigin);
//        doReturn(TestDto.class).when(quoteOrigin.getDtoType());
//        given(quoteOrigin.getUrl())
//                .willReturn(testUrl);
//        given(quoteOrigin.getDtoToQuoteFunction())
//                .willReturn(mockFunction);
//        given(quoteOrigin.getName())
//                .willReturn("");
//        given(quoteOrigin.getAll())
//                .willReturn(QuoteOrigin.values());
//
//        // when
//        var result = quoteProviderService.getQuote();
//
//        // then
//        StepVerifier.create(result)
//                .expectNext(expected)
//                .verifyComplete();
//    }
//
//    class TestDto {
//        String line;
//    }
//}