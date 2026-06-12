package org.example.backend.mapper;
import org.example.backend.dto.request.CategoryRequestDto;
import org.example.backend.dto.response.CategoryResponseDto;
import org.example.backend.model.Category;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryRequestDto categoryRequestDto);
    CategoryResponseDto toDto(Category category);
    List<CategoryResponseDto>toListDto(List<Category> categoryList);
}
