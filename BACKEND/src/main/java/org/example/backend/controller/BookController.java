package org.example.backend.controller;
import org.example.backend.dto.response.BookResponseDto;
import org.example.backend.util.ApiResponse;
import jakarta.validation.Valid;
import org.example.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/")
    public ResponseEntity<ApiResponse<BookResponseDto>> saveBook(@Valid  @ModelAttribute BookRequestDto requestDto) {
        System.out.println("Reached saveBook controller");
        BookResponseDto bookResponseDto=bookService.saveBook(requestDto);
        ApiResponse<BookResponseDto> response=new ApiResponse<>("success","new book added successfully",bookResponseDto);
        return ResponseEntity.status(201).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable UUID id){
        System.out.println("Reached deleteBook controller");
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Deleted successfully");
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<BookResponseDto>>>getAllBooks(){
        List<BookResponseDto>books=bookService.getBooks();
        ApiResponse<List<BookResponseDto>>response=new ApiResponse<>("success","Books retrieved from database successfully",books);
        return ResponseEntity.status(201).body(response);
    }
}