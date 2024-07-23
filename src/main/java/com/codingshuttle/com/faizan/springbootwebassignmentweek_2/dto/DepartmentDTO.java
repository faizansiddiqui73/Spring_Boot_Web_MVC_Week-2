package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private  Long id;

    @NotEmpty(message = "Department filed cannot be blank") //value size greater than zero
    @NotNull(message = "No null values are allowed")
    private String title;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email field cannot be blank")
    private String email;

    @AssertTrue
    @JsonProperty("isActive")
    private Boolean isActive;

    @PastOrPresent(message = "Department cannot be in future")
    private LocalDate createdAt;

    @NotNull(message = "Salary filed cannot be empty") //no whitespaces
    @Digits(integer = 5,fraction = 2,message = "The salary format should be in XXXXXX.YY")
    @Positive(message = "salary cannot be negative")
    @Min(value = 20000 ,message = "Department budget is not less than 20000")
    @Max(value = 70000,message = "Department cannot be exceed 70000")
    private double salary;

    @PastOrPresent(message = "Hired date cannot be in future")
    private LocalDate hiredAt;

    @URL(message = "URL is not valid")
    @NotBlank(message = "Social ID cannot be blank")
    private String socialId;


    @CreditCardNumber(message = "Enter a valid credit card number")
    @NotNull(message = "Null values not allowed")
    private String cardNumber;

//lombok will handle the getters and setters

    //For API Checking
    /*
    {
  "title" : "Electronics",
  "email" : "electronics@gmail.com",
  "isActive":true,
  "createdAt":"2024-07-24",
  "salary" : 54000,
  "hiredAt":"2021-09-09",
  "socialId":"https://instagram.com/electronics",
  "cardNumber": "463478452545"
}
     */

}
