package com.bartsassociates.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class BookReview {

    @Id
    private String bookReviewId;
    private Long bookCatalogId;
    private String comment;
    private Double rating;
}
