package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.dto;

import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.annotations.PasswordValidation;
import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.annotations.PrimeNumberValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;


    @NotBlank(message = "Title of Department field cannot be blank")
    @Size(min = 3, max = 25, message = "Number of characters in title should be in the range of [3,25]")
    private String title;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email field cannot be blank")
    private String email;


    @JsonProperty("isActive")
    @AssertTrue(message = "Department should be active")
    private Boolean isActive;

    @PastOrPresent(message = "Department cannot be in future")
//    @NotNull(message = "Field cannot be null")
    private LocalDate createdAt;

    @NotNull(message = "Salary filed cannot be empty") //no whitespaces
    @Digits(integer = 5, fraction = 2, message = "The salary format should be in XXXXXX.YY")
    @Positive(message = "salary cannot be negative")
    @Min(value = 20000, message = "Department budget is not less than 20000")
    @Max(value = 70000, message = "Department cannot be exceed 70000")
    private double salary;

    @PastOrPresent(message = "Hired date cannot be in future")
    private LocalDate hiredAt;

    @URL(message = "URL is not valid")
    @NotBlank(message = "Social ID cannot be blank")
    private String socialId;


    @CreditCardNumber(message = "Enter a valid credit card number")
    @NotNull(message = "Null values not allowed")
    private String cardNumber;

    @PrimeNumberValidation(message = "Field must be a prime number")
    @NotNull(message = "Field cannot be null")
    private Integer primeNumber;

    @PasswordValidation(message = "password must contains:- " +
            "1. contains one uppercase letter\n" +
            "2. contains one lowercase letter\n" +
            "3. contains one special character\n" +
            "4. minimum length is 10 characters")
    private String password;
}

//lombok will handle the getters and setters

    //For API Checking
    /*
 {
  "title" : "Electronics",
  "email" : "electronics@gmail.com",
  "isActive":true,
  "createdAt":"2024-07-23",
  "salary" : 54000.00,
  "hiredAt":"2021-09-09",
  "socialId": "https://instagram.com/electronics",
  "cardNumber": "5105105105105100",
  "primeNumber": 5 ,
  "password":"Faizan@1234"
}
    */

