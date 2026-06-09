package org.example.backend.controller;
import jakarta.validation.Valid;
import org.example.backend.dto.request.BookRequestDto;
import org.example.backend.dto.request.CategoryRequestDto;
import org.example.backend.dto.response.BookResponseDto;
import org.example.backend.dto.response.CategoryResponseDto;
import org.example.backend.service.CategoryService;
import org.example.backend.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    CategoryController(CategoryRequestDto categoryRequestDto, CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<CategoryResponseDto>> saveCategory(@Valid @ModelAttribute CategoryRequestDto requestDto) {
        System.out.println("Reached save Category controller");
        CategoryResponseDto categoryResponseDto=categoryService.saveCategory(requestDto);
        ApiResponse<CategoryResponseDto> response=new ApiResponse<>("success","new book added successfully",categoryResponseDto);
        return ResponseEntity.status(201).body(response);
    }

}
