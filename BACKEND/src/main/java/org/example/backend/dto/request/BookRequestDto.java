package org.example.backend.dto.request;
import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;
import lombok.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {

    @NotBlank(message="Title required")
    @Size(min=1,max=100,message = "Title name must be between 1 and 100 characters")
    private String title;

    @NotBlank(message="Author name required")
    private String author;

    @NotBlank(message="Isbn name required")
    private String isbn;

    @NotNull(message="Price cannot be null")
    @Positive(message="Enter positive value")
    @DecimalMin(value="50",message ="Only with Minimum price of 50 books allowed to sell")
    private Double price;

    @NotNull(message = "Stock cannot be null")
    @PositiveOrZero(message="Enter positive or zero")
    @Min(value=10,message ="Minimum stock must be 10")
    private Integer stock;

    @NotBlank(message = "Description required")
    private String description;

    @PastOrPresent(message = "Published date should be past or present")
    private LocalDate publishedDate;

    @NotNull(message = "Category id cannot be null")
    private Integer categoryId;

    @NotNull(message="Total number of sold items cannot be null")
    @Min(value=0,message="Total number of sold items must be positive or zero")
    private Integer totalSold;

    @NotNull(message="Rating should not be null")
    @Min(value=0,message="Minimum value should be zero and maximum value should be five")
    @Max(value=5,message="Minimum value should be zero and maximum value should be five")
    private Double rating;

    @NotNull(message = "Image cannot be null")
    private MultipartFile image;

}
