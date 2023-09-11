package com.bartsassociates.controller;

import com.bartsassociates.entity.BookCatalog;
import com.bartsassociates.service.BookCatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class BookCatelogController {

    private BookCatalogService bookCatalogService;

    public BookCatelogController(BookCatalogService bookCatalogService) {
        this.bookCatalogService = bookCatalogService;
    }

    @PostMapping("/bookcatalog")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BookCatalog> addBookCatalog(@RequestBody BookCatalog bookCatalog) {

        return bookCatalogService.addBookCatalog(bookCatalog);
    }

    @GetMapping("/bookcatalog")
    public Flux<BookCatalog> getAllBookCatalogs() {
        return bookCatalogService.getAllBookCatalogs();
    }

    @GetMapping("/bookcatalog/{id}")
    public Mono<BookCatalog> getBookCatalogById(@PathVariable("id") String id) {
        return bookCatalogService.getBookCatalogById(id);
    }

    @DeleteMapping("/bookcatalog/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteBookCatalogById(@PathVariable String id) {
        return bookCatalogService.deleteBookCatalogById(id);
    }

    @PutMapping("/bookcatalog/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<BookCatalog>> updateBookCatalog(@RequestBody BookCatalog bookCatalog, @PathVariable String id) {

        var updateBookCatalogMono = bookCatalogService.updateBookCatalog(bookCatalog, id);

        return updateBookCatalogMono
                .map(bookCatalog1 -> ResponseEntity.ok().body(bookCatalog1));
    }
}
