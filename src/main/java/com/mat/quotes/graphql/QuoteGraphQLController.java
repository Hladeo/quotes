package com.mat.quotes.graphql;

import com.mat.quotes.domain.Quote;
import com.mat.quotes.service.QuoteService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class QuoteGraphQLController {

    private QuoteService quoteService;

    public QuoteGraphQLController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @QueryMapping
    public Quote fetchRandomQuote() {
        return quoteService.fetchQuoteFromServer();
    }

    @MutationMapping
    public Quote addLikeToQuote(@Argument int id) {
        return quoteService.addLikeToQuote(id);
    }
}
