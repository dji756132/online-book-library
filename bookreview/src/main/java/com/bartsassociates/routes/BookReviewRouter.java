package com.bartsassociates.routes;

import com.bartsassociates.handler.BookReviewHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BookReviewRouter {

    @Bean
    public RouterFunction<ServerResponse> bookReviewRoute(BookReviewHandler bookReviewHandler) {

        return route()
                .POST("/bookreviews", bookReviewHandler::addBookReview)
                .GET("/bookreviews", bookReviewHandler::getBookReviews)
                .build();
    }
}
