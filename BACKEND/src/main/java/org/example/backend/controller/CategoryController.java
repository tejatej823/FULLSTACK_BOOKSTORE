package org.example.backend.controller;


import jakarta.validation.Valid;
import org.example.backend.dto.request.CategoryRequestDto;
import org.example.backend.dto.response.CategoryResponseDto;
import org.example.backend.service.CategoryService;
import org.example.backend.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<CategoryResponseDto>> addCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto){
        CategoryResponseDto categoryResponseDto= categoryService.addCategory(categoryRequestDto);
        ApiResponse<CategoryResponseDto>response=new ApiResponse<>("SUCCESS","Category added successfully",categoryResponseDto);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<CategoryResponseDto>>>getAllCategories(){
        List<CategoryResponseDto>allCategories=categoryService.getAllCategories();
        ApiResponse<List<CategoryResponseDto>>response=new ApiResponse<>("SUCCESS","All Categories retrieved successfully",allCategories);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponseDto>>getCategoryById(@PathVariable Integer id){
        CategoryResponseDto requestedCategory=categoryService.getCategoryById(id);
        System.out.println(requestedCategory);
        ApiResponse<CategoryResponseDto>response=new ApiResponse<>("SUCCESS","Book fetched successfully",requestedCategory);
        return ResponseEntity.status(200).body(response);
    }
}
