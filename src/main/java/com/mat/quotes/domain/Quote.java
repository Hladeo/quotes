package com.mat.quotes.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Quote {
    private String quote;
    private String author;

    public static Quote of(QuoteResponse response) {
        return Quote.builder()
                .author(response.getAuthor())
                .quote(response.getContent())
                .build();
    }
}
