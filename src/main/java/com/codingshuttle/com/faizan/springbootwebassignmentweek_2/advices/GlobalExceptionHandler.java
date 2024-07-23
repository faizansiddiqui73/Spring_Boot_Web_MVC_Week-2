package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchFieldException.class)
    public ResponseEntity<String> handleDepartmentNotFound(NoSuchElementException exception) {
        return new ResponseEntity<>("Element not found Exception", HttpStatus.NOT_FOUND);
    }
}
