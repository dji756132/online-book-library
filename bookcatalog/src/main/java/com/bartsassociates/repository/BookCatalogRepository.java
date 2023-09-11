package com.bartsassociates.repository;

import com.bartsassociates.entity.BookCatalog;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BookCatalogRepository extends ReactiveMongoRepository<BookCatalog, String> {
}
