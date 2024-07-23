package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.controller;

import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.dto.DepartmentDTO;
import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.services.DepartmentService;
import jakarta.validation.Valid;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
//@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    String msg = "Hello from Spring Boot server";

    @GetMapping(path = "/")
    public String getServer() {
        return msg;
    }

    @GetMapping(path = "/departments")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
//        return departmentService.getAllDepartments();
    }

    @PostMapping(path = "/departments")
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody @Valid DepartmentDTO inputDepartment) {
        return new ResponseEntity<>(departmentService.createDepartment(inputDepartment), HttpStatus.CREATED);
//        return departmentService.createDepartment(inputDepartment);
    }

    @PutMapping(path = "/departments")
    public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody @Valid DepartmentDTO departmentDTO) {
        return new ResponseEntity<>(departmentService.updateDepartment(departmentDTO), HttpStatus.OK);
//        return departmentService.updateDepartment(departmentDTO);
    }

    @DeleteMapping(path = "/departments")
    public ResponseEntity<Boolean> deleteDepartmentById(@RequestBody DepartmentDTO departmentDTO) {
        Boolean gotDeleted = departmentService.deleteDepartmentById(departmentDTO);
        if (gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
//        return departmentService.deleteDepartmentById(departmentDTO);
    }

    @GetMapping(path = "/departments/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable(name = "departmentId") Long id) {
        Optional<DepartmentDTO> departmentDTO = departmentService.getDepartment(id);
        return departmentDTO
                .map(departmentDTO1 -> new ResponseEntity<>(departmentDTO1, HttpStatus.OK))
                .orElseThrow(() -> new NoSuchElementException("Department Not found"));
//        return departmentService.getDepartment(id);
    }

    @ExceptionHandler(NoSuchFieldException.class)
    public ResponseEntity<String> handleDepartmentNotFound(NoSuchElementException exception) {
        return new ResponseEntity<>("Element not found Exception",HttpStatus.NOT_FOUND);
    }

//    IllegalArgumentException

}
