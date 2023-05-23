package com.mat.quotes.graphql;

import com.mat.quotes.domain.Quote;
import graphql.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@AutoConfigureGraphQlTester
@SpringBootTest
public class QuoteGraphQLControllerIT {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void shouldFetchRandomQuote() {
        // when
        Quote quote = this.graphQlTester.documentName("quoteDetails")
                .execute()
                .path("fetchRandomQuote")
                .entity(Quote.class)
                .get();

        // then
        Assert.assertNotNull(quote);
        Assert.assertNotNull(quote.getAuthor());
        Assert.assertNotNull(quote.getQuote());
    }
}