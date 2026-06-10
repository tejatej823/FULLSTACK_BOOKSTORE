package org.example.backend.exception.BookExceptions;

public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(String message){
        super(message);
    }
}
