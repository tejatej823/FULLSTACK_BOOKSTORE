package org.example.backend.service;
import org.example.backend.dto.BookRequest;
import org.example.backend.dto.BookResponse;
import org.example.backend.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.backend.repository.BookRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public BookResponse saveBook(BookRequest requestDto) {
        MultipartFile image= requestDto.getImage();
        if(image==null){
            System.out.println("Null");
        }
        else{
            System.out.println("Not null");
        }
        String imageUrl;
        try {
            imageUrl = cloudinaryService.uploadFile(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Book book = new Book();
        book.setTitle(requestDto.getTitle());
        book.setAuthor(requestDto.getAuthor());
        book.setIsbn(requestDto.getIsbn());
        book.setPrice(requestDto.getPrice());
        book.setStock(requestDto.getStock());
        book.setDescription(requestDto.getDescription());
        book.setPublishedDate(requestDto.getPublishedDate());
        book.setCategory(requestDto.getCategory());
        book.setImageUrl(imageUrl);
        bookRepository.save(book);
        BookResponse responseDto=new BookResponse();
        responseDto.setId(book.getId());
        responseDto.setTitle(book.getTitle());
        responseDto.setAuthor(book.getAuthor());
        responseDto.setIsbn(book.getIsbn());
        responseDto.setPrice(book.getPrice());
        responseDto.setStock(book.getStock());
        responseDto.setDescription(book.getDescription());
        responseDto.setPublishedDate(book.getPublishedDate());
        responseDto.setCategory(book.getCategory());
        responseDto.setImageUrl(book.getImageUrl());
        return responseDto;
    }
}

