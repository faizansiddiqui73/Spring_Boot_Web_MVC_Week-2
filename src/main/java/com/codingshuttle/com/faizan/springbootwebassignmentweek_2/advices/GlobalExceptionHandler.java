package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.advices;

import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleDepartmentNotFound(ResourceNotFoundException exception) {
        ApiError apiError = ApiError
                .builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
//        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
        return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(Exception.class) //this will handle all type of exception
    public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception exception){
        ApiError apiError = ApiError
                .builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(exception.getMessage())
                .build();
//        return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
        return buildErrorResponseEntity(apiError);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        //Now i need to handle all the errors what i define in request body if any argument is missed then it will come in list
        //MethodArgumentNotValidException. Exception to be thrown when a method argument fails validation
        // perhaps as a result of @Valid style validation, or perhaps because it is required.'
        //can also known as input validation errors
        List<String> errors =  exception //for detailed messages
                .getAllErrors()
                .stream()
                .map(error ->error.getDefaultMessage())
                .collect(Collectors.toList());
        ApiError apiError = ApiError
                .builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Input Validation Errors: ")
                .subErrors(errors)
                .build();
//        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);

        return buildErrorResponseEntity(apiError);
    }
    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError),apiError.getStatus());
    }

}
/*
    Resource Not Found Exception (404) arise : Getting a wrong id which is not in db,
    Suppose if we are updating(Put) or deleting(delete) then this will arise coz we in both the cases we need to find something in db
    so we create one method for that existing and throw exception.

    Internal Server Error (500) arise : when we are defining request body and something is missing then it arises
    happens in post,put,patch

    This is replaced by Method not valid Argument
    An internal server error, also known as a 500 Internal Server Error, is a generic HTTP status code that indicates a problem
    with the web server's side. It can occur when the server is unable to fulfill a request due to an unexpected condition

 */
