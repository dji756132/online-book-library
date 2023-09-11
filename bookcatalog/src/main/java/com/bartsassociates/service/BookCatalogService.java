package com.bartsassociates.service;

import com.bartsassociates.entity.BookCatalog;
import com.bartsassociates.repository.BookCatalogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class BookCatalogService {

    private BookCatalogRepository bookCatalogRepository;

    public BookCatalogService(BookCatalogRepository bookCatelogRepository) {
        this.bookCatalogRepository = bookCatelogRepository;
    }

    public Flux<BookCatalog> getAllBookCatalogs() {
        return bookCatalogRepository.findAll().log();
    }

    public Mono<BookCatalog> getBookCatalogById(String id) {
        return bookCatalogRepository.findById(id);
    }

    public Mono<BookCatalog> addBookCatalog(BookCatalog bookCatalog) {

//        log.info("add Book Category: {}", bookCatelog);
        System.out.println("add Book Catalog: " + bookCatalog);

        return bookCatalogRepository.save(bookCatalog).log();
    }

    public Mono<BookCatalog> updateBookCatalog(BookCatalog bookCatalog, String id) {
        return bookCatalogRepository.findById(id)
                .flatMap(bookCatalog1 -> {
                    bookCatalog1.setTitle(bookCatalog.getTitle());
                    bookCatalog1.setAuthor (bookCatalog.getAuthor());
                    bookCatalog1.setYear (bookCatalog.getYear());
                    return bookCatalogRepository.save(bookCatalog1);
                });
    }

    public Mono<Void> deleteBookCatalogById(String id) {
        return bookCatalogRepository.deleteById(id);
    }
}
