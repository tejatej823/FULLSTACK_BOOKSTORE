package org.example.backend.mapper;
import org.example.backend.dto.request.BookRequestDto;
import org.example.backend.dto.response.BookResponseDto;
import org.example.backend.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookResponseDto toDto(Book book);
    List<BookResponseDto> toDtoList(List<Book> books);
    @Mapping(target="imageUrl",source="imageUrl")
    Book toEntity(BookRequestDto bookRequestDto,String imageUrl);
}
