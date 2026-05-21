package org.example.backend.mapper;
import org.example.backend.dto.response.BookResponse;
import org.example.backend.model.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookResponse toDto(Book book);
    List<BookResponse> toDtoList(List<Book> books);
}
