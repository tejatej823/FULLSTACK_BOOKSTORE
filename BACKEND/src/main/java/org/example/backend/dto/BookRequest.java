package org.example.backend.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Setter
@Getter
@Data
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
