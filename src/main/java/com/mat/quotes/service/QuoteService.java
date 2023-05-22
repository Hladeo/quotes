package com.mat.quotes.service;

import com.mat.quotes.domain.Quote;
import com.mat.quotes.domain.QuoteResponse;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Data
@Service
public class QuoteService {

    private Map<Quote, Long> quotes = new HashMap<>();

    private final WebClient webClient;

    public QuoteService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Quote fetchQuoteFromServer() {
        QuoteResponse response = webClient.get()
                .uri("/")
                .retrieve()
                .bodyToMono(QuoteResponse.class)
                .block();
        Quote quote = Quote.of(response);

        quotes.put(quote, 0L);

        return quote;
    }
}
