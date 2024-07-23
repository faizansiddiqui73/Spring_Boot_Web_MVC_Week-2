package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.services;

import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.dto.DepartmentDTO;
import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.entities.DepartmentEntity;
import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }
        public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities
                .stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity,DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public DepartmentDTO getDepartment(Long id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElse(null);
        return modelMapper.map(departmentEntity,DepartmentDTO.class);
    }


    public DepartmentDTO createDepartment(DepartmentEntity inputDepartment) {
        DepartmentEntity departmentEntity = departmentRepository.save(inputDepartment);
        return modelMapper.map(departmentEntity,DepartmentDTO.class);
    }
}


