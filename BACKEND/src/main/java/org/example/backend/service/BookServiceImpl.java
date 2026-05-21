package org.example.backend.service;
import org.example.backend.mapper.BookMapper;
import org.example.backend.dto.request.BookRequest;
import org.example.backend.dto.response.BookResponse;
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
        System.out.println(responseDto);
        return responseDto;
    }

    @Override
    public void deleteBook(UUID id){
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookResponse>getBooks(){
        List<Book>books=bookRepository.findAll();
        return bookMapper.toDtoList(books);
    }

}

