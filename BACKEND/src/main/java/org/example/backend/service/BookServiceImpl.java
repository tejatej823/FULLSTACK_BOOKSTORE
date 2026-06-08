package org.example.backend.service;
import org.example.backend.dto.response.BookResponseDto;
import org.example.backend.exception.BookAlreadyExistsException;
import org.example.backend.mapper.BookMapper;
import org.example.backend.dto.request.BookRequestDto;
import org.example.backend.model.Book;
import org.example.backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.*;
import java.util.UUID;
import org.example.backend.exception.*;

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
        Optional<Book>existingBook=bookRepository.findByIsbn(requestDto.getIsbn());
        if(!existingBook.isPresent()){
        Book book = bookMapper.toEntity(requestDto,imageUrl);
        bookRepository.save(book);
        return bookMapper.toDto(book);}
        else{
            throw new BookAlreadyExistsException("Book already exist");
        }
    }

    @Override
    public String deleteBook(UUID id){
        Optional<Book>existingBook=bookRepository.findById(id);
        if(existingBook.isPresent()){
            bookRepository.deleteById(id);
        }
        else{
            throw new BookNotFoundException("Book does not exists.");
        }
        return "Book  deleted successfully";
    }

    @Override
    public List<BookResponseDto>getBooks(){
        List<Book>books=bookRepository.findAll();
        return bookMapper.toDtoList(books);
    }
}