package org.example.backend.service;
import org.example.backend.dto.BookResponse;
import org.example.backend.dto.BookRequest;

import java.util.List;
import java.util.UUID;


public interface BookService{
    BookResponse saveBook(BookRequest requestDto);
    void deleteBook(UUID id);
    List<BookResponse> getBooks();
}
