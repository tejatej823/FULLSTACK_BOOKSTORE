package org.example.backend.dto.request;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequestDto {

    @NotBlank(message="Category name cannot be empty or whitespace")
    private String categoryName;

}
