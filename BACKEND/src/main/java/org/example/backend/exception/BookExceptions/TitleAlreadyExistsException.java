package org.example.backend.exception.BookExceptions;

public class TitleAlreadyExistsException extends RuntimeException{
    public TitleAlreadyExistsException(String message){
        super(message);
    }
}