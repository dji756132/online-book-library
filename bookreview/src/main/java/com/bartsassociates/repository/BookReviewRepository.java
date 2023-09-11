package com.bartsassociates.repository;

import com.bartsassociates.entity.BookReview;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface BookReviewRepository extends ReactiveMongoRepository<BookReview, String> {
    Flux<BookReview> findBookReviewsByBookCatalogId(Long bookCatalogId);
}
