package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Departments")
public class DepartmentEntity {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String title;
    private Boolean isActive;
    private LocalDate createdAt;
}
