package org.example.backend.service;
import org.example.backend.dto.response.BookResponseDto;
import org.example.backend.dto.request.BookRequestDto;
import org.springframework.data.domain.Page;

import java.util.UUID;


public interface BookService{
    BookResponseDto saveBook(BookRequestDto requestDto);
    String deleteBook(UUID id);
    Page<BookResponseDto> getBooks(int page, int size);
}
