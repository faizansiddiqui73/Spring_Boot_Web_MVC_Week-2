package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.controller;

import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.dto.DepartmentDTO;
import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@RequestMapping(path = "/departments")
public class DepartmentController {
    private final  DepartmentService departmentService;
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

    @GetMapping(path = "/departments/{departmentId}")
    public DepartmentDTO getDepartment(@PathVariable (name = "departmentId") Long id) {
        return departmentService.getDepartment(id);
    }

    @PostMapping(path = "/departments")
    public DepartmentDTO createDepartment(@RequestBody DepartmentDTO inputDepartment){
        return departmentService.createDepartment(inputDepartment);
    }

    @PutMapping(path = "/departments/{departmentId}")
    public DepartmentDTO updateDepartment(@PathVariable Long departmentId,
            @RequestBody DepartmentDTO updateDepartmentDTO){
        return departmentService.updateDepartment(departmentId,updateDepartmentDTO);
    }

    @DeleteMapping(path = "/departments/{departmentId}")
    public Boolean deleteDepartmentById(@PathVariable Long departmentId){
       return departmentService.deleteDepartmentById(departmentId);
    }
}
