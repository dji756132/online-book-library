package com.bartsassociates.handler;

import com.bartsassociates.entity.BookReview;
import com.bartsassociates.repository.BookReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class BookReviewHandler {

    private BookReviewRepository bookReviewRepository;

    public BookReviewHandler(BookReviewRepository bookReviewRepository) {
        this.bookReviewRepository = bookReviewRepository;
    }

    public Mono<ServerResponse> addBookReview(ServerRequest request) {

        return request.bodyToMono(BookReview.class)
                .flatMap(bookReviewRepository::save)
                .flatMap(ServerResponse.status(HttpStatus.CREATED)::bodyValue);
    }

    public Mono<ServerResponse> getBookReviews(ServerRequest request) {

        var bookCatalogId = request.queryParam("bookCatalogId");

        if(bookCatalogId.isPresent()) {
            var bookReviewsFlux = bookReviewRepository
                    .findBookReviewsByBookCatalogId(Long.valueOf(bookCatalogId.get()));
            return buildBookReviewsResponse(bookReviewsFlux);
        }
        else {
            var bookReviewsFlux = bookReviewRepository
                    .findAll();
            return buildBookReviewsResponse(bookReviewsFlux);
        }

    }

    private static Mono<ServerResponse> buildBookReviewsResponse(Flux<BookReview> bookReviewsFlux) {
        return ServerResponse.ok().body(bookReviewsFlux, BookReview.class);
    }
}
