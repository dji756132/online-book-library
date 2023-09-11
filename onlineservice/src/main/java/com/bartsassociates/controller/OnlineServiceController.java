package com.bartsassociates.controller;

import com.bartsassociates.client.BookCatalogRestClient;
import com.bartsassociates.client.BookReviewRestClient;
import com.bartsassociates.entity.OnlineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/onlineservice")
public class OnlineServiceController {

    private BookCatalogRestClient bookCatalogRestClient;
    private BookReviewRestClient bookReviewRestClient;

    public OnlineServiceController(BookCatalogRestClient bookCatalogRestClient, BookReviewRestClient bookReviewRestClient) {
        this.bookCatalogRestClient = bookCatalogRestClient;
        this.bookReviewRestClient = bookReviewRestClient;
    }

    @GetMapping("/{id}")
    public Mono<OnlineService> getOnlineServiceById(@PathVariable("id") String bookId) {

        return bookCatalogRestClient.getBookCatalog(bookId)
                .flatMap(bookCatalog -> {
                    var bookReviewsListMono = bookReviewRestClient.getBookReviews(bookId)
                            .collectList();
                    return bookReviewsListMono.map(bookReviews -> new OnlineService(bookCatalog, bookReviews));
                });
    }
}
