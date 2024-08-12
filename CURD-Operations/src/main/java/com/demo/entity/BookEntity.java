package com.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookEntity {

    @Id
    @NotNull(message = "book ID can not be null")
    private Integer bookId;

    @NotNull(message = "Book Title can Not be null")
    private String bookName;

    @Size(min=10, max=65,message = "Book description must be between 10 and 40 characters")
    private String bookDescription;

    @DecimalMax(value = "1200.00" , message = "Book prize should not be greater than 1200.00")
    private Double bookPrize;
    private String bookAuthor;
}
