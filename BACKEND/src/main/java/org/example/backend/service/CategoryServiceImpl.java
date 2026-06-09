package org.example.backend.service;

import org.example.backend.dto.request.CategoryRequestDto;
import org.example.backend.dto.response.CategoryResponseDto;
import org.example.backend.mapper.CategoryMapper;
import org.example.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.backend.model.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {  // ✅ CORRECT
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    CategoryMapper categoryMapper;

    public CategoryResponseDto saveCategory(CategoryRequestDto requestDto){
        Category category=categoryMapper.toEntity(requestDto);
        categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }
}
