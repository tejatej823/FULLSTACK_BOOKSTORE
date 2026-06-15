package org.example.backend.dto.response;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class BookResponseDto {
    private UUID id;
    private String title;
    private String author;
    private String isbn;
    private Double price;
    private Integer stock;
    private String description;
    private LocalDate publishedDate;
    private String categoryName;
    private Integer totalSold;
    private Double rating;
    private Integer categoryId;
    private String imageUrl;
}
