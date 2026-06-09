package org.example.backend.mapper;

import org.example.backend.dto.request.CategoryRequestDto;
import org.example.backend.dto.response.CategoryResponseDto;
import org.example.backend.model.Category;

public interface CategoryMapper {
    CategoryResponseDto toDto(Category category);
    Category toEntity(CategoryRequestDto categoryRequestDto);
}
