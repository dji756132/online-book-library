package com.bartsassociates.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class BookCatalog {

    @Id
    private String bookId;

    private String title;
    private List<String> author;
    private Integer year;
}
