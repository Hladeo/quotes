package com.mat.quotes.controller;

import com.mat.quotes.domain.Quote;
import com.mat.quotes.service.QuoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class QuoteRestController {

    private QuoteService quoteService;

    public QuoteRestController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping(path = "/")
    public Quote fetchRandomQuote() {
        return quoteService.fetchQuoteFromServer();
    }
}
