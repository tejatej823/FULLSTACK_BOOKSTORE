package org.example.backend.mapper;
import org.example.backend.dto.request.BookRequestDto;
import org.example.backend.dto.response.BookResponseDto;
import org.example.backend.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mappings({
            @Mapping(source = "category.categoryId", target = "categoryId"),
            @Mapping(source = "category.categoryName", target = "categoryName")
    })
    BookResponseDto toDto(Book book);

    BookResponseDto toDto(Book book,Integer categoryId,String categoryName);

    List<BookResponseDto> toDtoList(List<Book> books);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    Book toEntity(BookRequestDto bookRequestDto, String imageUrl);

}
