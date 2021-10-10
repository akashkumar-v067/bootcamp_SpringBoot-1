package com.example.bootcamp_rest_1;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotRegisteredException extends RuntimeException {

    public UserNotRegisteredException(String message) {
        super(message+" Not registered...");
    }
}
