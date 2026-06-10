package org.example.backend.exception;

import java.util.Map;

import org.example.backend.exception.BookExceptions.BookAlreadyExistsException;
import org.example.backend.exception.BookExceptions.BookNotFoundException;
import org.example.backend.exception.CategoryExceptions.CategoryAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.example.backend.util.ErrorResponse;
import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionalHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse<Map<String,String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        ErrorResponse<Map<String,String>> response=new ErrorResponse<>(400,"VALIDATION_ERROR",errors);
        return ResponseEntity.status(400).body(response);
    }
    @ExceptionHandler(BookAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse<String>>handleBookAlreadyExistsException(BookAlreadyExistsException ex){
        String message=ex.getMessage();
        ErrorResponse<String>response=new ErrorResponse<>(409,"CONFLICT",message);
        return ResponseEntity.status(409).body(response);
    }
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponse<String>>handleBookNotFoundException(BookNotFoundException ex){
        String message=ex.getMessage();
        ErrorResponse<String>response=new ErrorResponse<>(404,"NOT_FOUND",message);
        return ResponseEntity.status(404).body(response);
    }
    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse<String>>handleCategoryAlreadyExistsException(CategoryAlreadyExistsException ex){
        String message=ex.getMessage();
        ErrorResponse<String>response=new ErrorResponse<>(409,"CONFLICT",message);
        return ResponseEntity.status(409).body(response);
    }
}