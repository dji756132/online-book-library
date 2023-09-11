package com.bartsassociates.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookReview {

    private String bookReviewId;
    private Long bookCatalogId;
    private String comment;
    private Double rating;
}
