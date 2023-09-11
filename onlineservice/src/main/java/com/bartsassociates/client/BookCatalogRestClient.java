package com.bartsassociates.client;

import com.bartsassociates.entity.BookCatalog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class BookCatalogRestClient {

    private WebClient webClient;

    @Value("${restClient.bookCatalogUrl}")
    private String bookCatalogUrl;

    public BookCatalogRestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<BookCatalog> getBookCatalog(String bookId) {

        var url = bookCatalogUrl.concat("/{id}");

        return webClient.get()
                .uri(url, bookId)
                .retrieve()
                .bodyToMono(BookCatalog.class)
                .log();
    }
}
