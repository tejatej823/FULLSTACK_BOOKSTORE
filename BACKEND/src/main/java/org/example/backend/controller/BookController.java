package org.example.backend.controller;
import org.example.backend.dto.response.ApiResponse;
import jakarta.validation.Valid;
import org.example.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.backend.dto.request.BookRequest;
import org.example.backend.dto.response.BookResponse;

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
    public ResponseEntity<BookResponse> saveBook(@Valid  @ModelAttribute BookRequest requestDto) {
        System.out.println("Reached saveBook controller");
        return ResponseEntity.status(201).body(bookService.saveBook(requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable UUID id){
        System.out.println("Reached deleteBook controller");
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<BookResponse>>>getAllBooks(){
        List<BookResponse>books=bookService.getBooks();
        ApiResponse<List<BookResponse>>response=new ApiResponse<>("success","Book data retrieved successfully",books);
        return ResponseEntity.status(200).body(response);
    }
}