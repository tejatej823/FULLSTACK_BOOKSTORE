package org.example.backend.service;

import org.example.backend.dto.request.CategoryRequestDto;
import org.example.backend.dto.response.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto);
    List<CategoryResponseDto> getAllCategories();
}
