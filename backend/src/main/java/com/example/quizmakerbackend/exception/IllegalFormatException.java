package com.example.quizmakerbackend.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Illegal Format", value = org.springframework.http.HttpStatus.BAD_REQUEST)
public class IllegalFormatException extends RuntimeException{
    public IllegalFormatException(String message) {
        super(message);
    }
}
