package org.example.backend.controller;
import org.example.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.backend.dto.BookRequest;
import org.example.backend.dto.BookResponse;

@RestController
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    @PostMapping("/books")
    public ResponseEntity<BookResponse> saveBook(@ModelAttribute BookRequest requestDto) {
        System.out.println("Reached controller");
        return ResponseEntity.status(201).body(bookService.saveBook(requestDto));
    }
}