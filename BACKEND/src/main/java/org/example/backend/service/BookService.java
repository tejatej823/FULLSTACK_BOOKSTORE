package org.example.backend.service;
import org.example.backend.dto.BookResponse;
import org.example.backend.dto.BookRequest;


public interface BookService{
    BookResponse saveBook(BookRequest requestDto);
}
