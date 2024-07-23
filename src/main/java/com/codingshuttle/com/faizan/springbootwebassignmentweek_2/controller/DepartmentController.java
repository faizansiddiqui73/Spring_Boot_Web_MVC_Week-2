package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.controller;

import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.dto.DepartmentDTO;
import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.entities.DepartmentEntity;
import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@RequestMapping(path = "/departments")
public class DepartmentController {
    private DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    String msg = "Hello from Spring Boot server";
    @GetMapping(path = "/")
    public String getServer(){
        return msg;
    }

    @GetMapping(path = "/departments")
    public List<DepartmentDTO> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping(path = "/departments/{id}")
    public DepartmentDTO getDepartment(@PathVariable Long id) {
        return departmentService.getDepartment(id);
    }

    @PostMapping(path = "/departments")
    public DepartmentDTO createDepartment(@RequestBody DepartmentEntity inputDepartment){
        return departmentService.createDepartment(inputDepartment);
    }
}
