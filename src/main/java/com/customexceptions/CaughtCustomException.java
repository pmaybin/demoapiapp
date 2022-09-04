package com.customexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CaughtCustomException extends RuntimeException{
    public CaughtCustomException(String message){
        super(message);
    }
}


