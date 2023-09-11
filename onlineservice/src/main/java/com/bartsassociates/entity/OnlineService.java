package com.bartsassociates.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnlineService {

    private BookCatalog bookCatalog;
    private List<BookReview> bookReviewList;
}
