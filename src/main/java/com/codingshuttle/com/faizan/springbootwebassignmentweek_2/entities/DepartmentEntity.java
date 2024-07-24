package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;

@Entity
@Data
@Table(name = "Departments")
public class DepartmentEntity {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String email;
    @JsonProperty("isActive")
    private Boolean isActive;
    private LocalDate createdAt;
    private double salary;
    private LocalDate hiredAt;
    private String socialId;
    private String cardNumber;
    private Integer primeNumber;
    private String password;

}
