package org.example.backend.dto;

import org.springframework.web.multipart.MultipartFile;
import lombok.*;
import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private String title;
    private String author;
    private String isbn;
    private Double price;
    private Integer stock;
    private String description;
    private LocalDate publishedDate;
    private String category;
    private MultipartFile image;


}
