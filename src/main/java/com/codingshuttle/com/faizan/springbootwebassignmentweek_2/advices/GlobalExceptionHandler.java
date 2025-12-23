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
   MethodArgumentNotValidException. Exception to be thrown when a method argument fails validation - 400 Bad Request
   Validation failure = 400
   400 Bad Request indicates that the server cannot process the request due to invalid syntax, missing fields, or failed validation on the client side.

    Resource Not Found Exception (404) arise : Getting a wrong id which is not in db,
    Suppose if we are updating(Put) or deleting(delete) then this will arise coz we in both the cases we need to find something in db
    so we create one method for that existing and throw exception.

   A 500 Internal Server Error occurs when the server encounters an unexpected condition it cannot handle.
   In POST, PUT, or PATCH requests, it often happens when required request body fields are missing and the server
   lacks proper validation or exception handling.
   Application crash/bug = 500

   This is replaced by Method not valid Argument(400)

			Exception                        	    Meaning	                             HTTP Status
			MethodArgumentNotValidException	      Invalid request data	                 400
			ResourceNotFoundException	            Resource does not exist	               404
			AccessDeniedException	                Unauthorized access	                   403
			Internal Server Error	                Server bug	                           500
 */
