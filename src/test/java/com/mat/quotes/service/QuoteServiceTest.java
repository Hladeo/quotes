package com.mat.quotes.service;

import com.mat.quotes.domain.Quote;
import com.mat.quotes.domain.QuoteResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuoteServiceTest {

    @Mock
    private WebClient webClient;

    @SuppressWarnings("rawtypes")
    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    @InjectMocks
    private QuoteService quoteService;

    @Test
    void shouldfetchQuoteFromServer() {
        // given
        QuoteResponse response = new QuoteResponse();
        response.setContent("Quote");
        response.setAuthor("Author");

        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(QuoteResponse.class)).thenReturn(Mono.just(response));

        // when
        Quote result = quoteService.fetchQuoteFromServer();

        // then
        assertEquals("Quote", result.getQuote());
        assertEquals("Author", result.getAuthor());
    }
}