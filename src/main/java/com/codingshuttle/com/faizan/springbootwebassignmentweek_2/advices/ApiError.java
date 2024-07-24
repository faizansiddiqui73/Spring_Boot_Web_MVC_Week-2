package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data         //Lombok generates getters and setters for all fields,
@Builder    //The @Builder annotation in Lombok is used to implement the builder pattern for your classes.
            // The builder pattern is a design pattern used to create complex objects step by step
public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> subErrors;
}
