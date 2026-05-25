package org.example.backend.service;
import org.example.backend.dto.response.BookResponseDto;
import org.example.backend.dto.request.BookRequestDto;

import java.util.List;
import java.util.UUID;


public interface BookService{
    BookResponseDto saveBook(BookRequestDto requestDto);
    void deleteBook(UUID id);
    List<BookResponseDto> getBooks();
}
