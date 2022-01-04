package com.playground.randomquote.config;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.config.DelegatingWebFluxConfiguration;

@Configuration
public class WebFluxConfiguration extends DelegatingWebFluxConfiguration {



    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public ErrorWebExceptionHandler errorWebExceptionHandler(ErrorAttributes errorAttributes,
                                                             ServerProperties serverProperties,
                                                             WebProperties webProperties,
                                                             ApplicationContext applicationContext,
                                                             ServerCodecConfigurer configurer) {
        var webFluxErrorHandler = new WebFluxErrorHandler(
                errorAttributes,
                webProperties.getResources(),
                serverProperties,
                applicationContext);

        webFluxErrorHandler.setMessageWriters(configurer.getWriters());

        return webFluxErrorHandler;
    }
}
