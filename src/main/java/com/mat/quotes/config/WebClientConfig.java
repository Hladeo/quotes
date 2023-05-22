package com.mat.quotes.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${quote.source.url}")
    private String quoteSourceUrl;

    @Bean
    public WebClient quoteWebClient() {
        return WebClient.builder().baseUrl(quoteSourceUrl).build();
    }
}
