package org.example.backend.service;
import org.example.backend.dto.response.BookResponseDto;
import org.example.backend.exception.BookExceptions.BookAlreadyExistsException;
import org.example.backend.exception.BookExceptions.BookNotFoundException;
import org.example.backend.exception.CategoryExceptions.CategoryNotFoundException;
import org.example.backend.mapper.BookMapper;
import org.example.backend.dto.request.BookRequestDto;
import org.example.backend.model.Book;
import org.example.backend.model.Category;
import org.example.backend.repository.BookRepository;
import org.example.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.*;
import java.util.UUID;

@Service
public class  BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public BookResponseDto saveBook(BookRequestDto requestDto) {
        MultipartFile image= requestDto.getImage();
        String imageUrl;
        try {
            imageUrl = cloudinaryService.uploadFile(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String isbn=requestDto.getIsbn();
        boolean isBookAlreadyExisted= bookRepository.existsByIsbn(isbn);
        if(isBookAlreadyExisted){
            throw new BookAlreadyExistsException("Book already existed");
        }
        Book book = bookMapper.toEntity(requestDto,imageUrl);
        Category category= categoryRepository.findById(requestDto.getCategoryId()).orElseThrow(()->new CategoryNotFoundException("Category did not exist"));

        book.setCategory(category);
        System.out.println(book.getRating());
        bookRepository.save(book);
        return bookMapper.toDto(book);
    }

    @Override
    public String deleteBook(UUID id){
        boolean checkBookAlreadyExisted=bookRepository.existsById(id);
        if(!checkBookAlreadyExisted){
            throw new BookNotFoundException("Book does not exists.");
        }
        bookRepository.deleteById(id);
        return "Book  deleted successfully";
    }

    @Override
    public Page<BookResponseDto> getBooks(int page, int size,String sortBy,boolean ascending){
        Sort sort=ascending? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(page,size,sort);
        Page<Book>BookEntityPage=bookRepository.findAll(pageable);
        return BookEntityPage.map(bookMapper::toDto);
    }
}