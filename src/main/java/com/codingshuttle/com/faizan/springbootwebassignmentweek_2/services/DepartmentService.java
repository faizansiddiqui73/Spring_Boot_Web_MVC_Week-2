package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.services;

import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.dto.DepartmentDTO;
import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.entities.DepartmentEntity;
import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {


    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }


    //    public List<DepartmentDTO> getAllDepartments() {
//        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
//        return departmentEntities
//                .stream()
//                .map(departmentEntity -> map.)
////        return departmentRepository.findAll();
//    }

    public DepartmentDTO getDepartment(Long id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElse(null);
        return modelMapper.map(departmentEntity,DepartmentDTO.class);
    }


    public DepartmentEntity createDepartment(DepartmentEntity inputDepartment) {
        return departmentRepository.save(inputDepartment);
    }
}


