package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.advices;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

@Data
public class ApiResponse<T> { //The T in ApiResponse<T> is a generic type parameter that makes the ApiResponse class flexible

    @JsonFormat(pattern = "")
    private LocalDateTime timeStamp;
    private T data; //T is a generic type parameter
    private ApiError apiError;

    //time is need to use everytime

    public ApiResponse(){
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data){
        this(); //initialized the default constructor
        this.data = data;
    }
     public ApiResponse(ApiError apiError){
        this(); //initialized the default constructor
         this.apiError = apiError;
     }
     //When data will be called then error won't
}
