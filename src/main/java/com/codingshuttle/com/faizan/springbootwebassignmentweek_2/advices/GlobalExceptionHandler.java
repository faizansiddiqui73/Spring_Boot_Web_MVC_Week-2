package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.advices;

import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleDepartmentNotFound(ResourceNotFoundException exception) {
        ApiError apiError = ApiError
                .builder()
                .status(HttpStatus.NOT_FOUND)
                .message("Resource Not Found")
                .build();
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
}
