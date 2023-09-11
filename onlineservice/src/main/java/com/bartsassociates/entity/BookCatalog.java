package com.bartsassociates.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCatalog {

    private String bookId;
    private String title;
    private List<String> author;
    private Integer year;
}