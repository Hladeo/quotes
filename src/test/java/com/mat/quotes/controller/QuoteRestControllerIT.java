package com.mat.quotes.controller;

import com.mat.quotes.domain.Quote;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "36000")
public class QuoteRestControllerIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void shouldFetchRandomQuote() {
        webTestClient.get()
                .uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Quote.class)
                .value(quote -> {
                    assertNotNull(quote.getQuote());
                    assertNotNull(quote.getAuthor());
                });
    }
}