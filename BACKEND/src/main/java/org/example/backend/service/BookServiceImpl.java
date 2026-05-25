package org.example.backend.service;
import org.example.backend.dto.response.BookResponseDto;
import org.example.backend.mapper.BookMapper;
import org.example.backend.dto.request.BookRequestDto;
import org.example.backend.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.backend.repository.BookRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public BookResponseDto saveBook(BookRequestDto requestDto) {
        MultipartFile image= requestDto.getImage();
        String imageUrl;
        try {
            imageUrl = cloudinaryService.uploadFile(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Book book = bookMapper.toEntity(requestDto,imageUrl);
        bookRepository.save(book);
        return bookMapper.toDto(book);
    }

    @Override
    public void deleteBook(UUID id){
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookResponseDto>getBooks(){
        List<Book>books=bookRepository.findAll();
        return bookMapper.toDtoList(books);
    }

}

