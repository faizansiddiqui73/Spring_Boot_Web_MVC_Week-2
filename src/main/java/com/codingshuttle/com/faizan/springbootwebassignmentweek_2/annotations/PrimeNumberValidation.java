package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)//3
@Target({ElementType.FIELD,ElementType.PARAMETER})//4 //5 now define new class for PrimeNumberValidator
@Constraint(validatedBy = {PrimeNumberValidator.class}) //6
public @interface PrimeNumberValidation {//1
    //2
    String message() default "{jakarta.validation.constraints.NotBlank.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
