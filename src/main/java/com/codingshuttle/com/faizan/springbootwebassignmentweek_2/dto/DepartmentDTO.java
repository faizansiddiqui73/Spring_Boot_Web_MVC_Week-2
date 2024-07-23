package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.dto;

import java.time.LocalDate;



public class DepartmentDTO {
    private  Long id;
    private String title;
    private Boolean isActive;
    private LocalDate createdAt;

    public DepartmentDTO(){

    }

    public DepartmentDTO(Long id, String title, Boolean isActive, LocalDate createdAt) {
        this.id = id;
        this.title = title;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
