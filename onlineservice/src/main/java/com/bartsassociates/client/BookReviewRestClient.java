package com.bartsassociates.client;

import com.bartsassociates.entity.BookReview;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;

@Component
@Slf4j
public class BookReviewRestClient {

    private WebClient webClient;

    @Value("${restClient.bookReviewsUrl}")
    private String bookReviewsUrl;

    public BookReviewRestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<BookReview> getBookReviews(String bookId) {

        var url = UriComponentsBuilder.fromHttpUrl(bookReviewsUrl)
                .queryParam("bookCatalogId", bookId)
                .buildAndExpand().toString();

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToFlux(BookReview.class);
    }
}
