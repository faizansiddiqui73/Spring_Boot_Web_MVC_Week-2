package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
