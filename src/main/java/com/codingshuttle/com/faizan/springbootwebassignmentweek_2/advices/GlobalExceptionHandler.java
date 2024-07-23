package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiError> handleDepartmentNotFound(NoSuchElementException exception) {
        ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND).message("Resource Not Found").build();
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
}
