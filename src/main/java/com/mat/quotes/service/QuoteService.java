package com.mat.quotes.service;

import com.mat.quotes.domain.Quote;
import com.mat.quotes.domain.QuoteResponse;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class QuoteService {

    private List<Quote> quotes = new ArrayList<>();

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

        quotes.add(quote);

        return quote;
    }

    public Quote addLikeToQuote(int id) {
        Quote quote = quotes.size() - 1 >= id ? quotes.get(id) : null;
        return Optional.ofNullable(quote)
                .orElseThrow(() -> new IllegalArgumentException("Id not found"))
                .incrementLikesBy(1);
    }
}
