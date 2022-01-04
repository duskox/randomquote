package com.playground.randomquote.config;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;

public class WebFluxErrorHandler extends DefaultErrorWebExceptionHandler {

    public WebFluxErrorHandler(ErrorAttributes errorAttributes,
                               WebProperties.Resources resources,
                               ServerProperties serverProperties,
                               ApplicationContext applicationContext) {
        super(errorAttributes,
                resources,
                serverProperties.getError(),
                applicationContext);
    }

    @Override
    protected Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
        var error = getError(request);
        return handleError(error);
    }

    private Mono<ServerResponse> handleError(Throwable throwable) {
        var details = new HashMap<String, String>();
        details.put("detail", throwable.getMessage());
        return ServerResponse
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(BodyInserters.fromValue(
                        ErrorDto
                                .builder()
                                .failureReason("Oooops!")
                                .details(details)
                                .build()
                ));
    }
}
