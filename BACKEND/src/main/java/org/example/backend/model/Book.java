package org.example.backend.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String title;

    private String author;

    @Column(unique = true)
    private String isbn;

    private Double price;
    private Integer stock;
    private String description;
    private LocalDate publishedDate;
    private Integer totalSold;
    private Double rating;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categoryId")
    private Category category;
    private String imageUrl;
}