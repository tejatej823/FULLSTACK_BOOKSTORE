package org.example.backend.controller;
import org.example.backend.dto.response.BookResponseDto;
import org.example.backend.util.ApiResponse;
import jakarta.validation.Valid;
import org.example.backend.service.BookService;
import org.example.backend.util.PaginationApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.backend.dto.request.BookRequestDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<BookResponseDto>> saveBook(@Valid  @ModelAttribute BookRequestDto requestDto) {
        BookResponseDto bookResponseDto=bookService.saveBook(requestDto);
        System.out.println(bookResponseDto.getRating());
        ApiResponse<BookResponseDto> response=new ApiResponse<>(true,"new book added successfully",bookResponseDto);
        return ResponseEntity.status(201).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable UUID id){
        System.out.println("Reached deleteBook controller");
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Deleted successfully");
    }

    @GetMapping
    public ResponseEntity<PaginationApiResponse<List<BookResponseDto>>> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending
    ) {

        Page<BookResponseDto> booksDtoPage = bookService.getBooks(page, size,sortBy,ascending);
        List<BookResponseDto> data = booksDtoPage.getContent();

        PaginationApiResponse<List<BookResponseDto>> response =
                new PaginationApiResponse<>(
                        true,
                        "Books retrieved successfully",
                        data,
                        booksDtoPage.getNumber(),
                        booksDtoPage.getSize(),
                        booksDtoPage.getTotalElements(),
                        booksDtoPage.getTotalPages()
                );
        return ResponseEntity.ok(response);
    }
}