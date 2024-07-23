package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.services;

import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.dto.DepartmentDTO;
import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.entities.DepartmentEntity;
import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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


    public DepartmentDTO createDepartment(DepartmentDTO inputDepartment) {
        //convert
        DepartmentEntity  toSaveDepartment = modelMapper.map(inputDepartment,DepartmentEntity.class);
        DepartmentEntity departmentEntity = departmentRepository.save(toSaveDepartment);
        return modelMapper.map(departmentEntity,DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO) {
        Long departmentId = departmentDTO.getId();
        //find
         DepartmentEntity findingDepartment = departmentRepository.findById(departmentId).orElse(null);
         DepartmentEntity conversionToEntity = modelMapper.map(departmentDTO,DepartmentEntity.class);
         conversionToEntity.setId(departmentId);
         DepartmentEntity toSaveEntity = departmentRepository.save(conversionToEntity);
         return modelMapper.map(conversionToEntity,DepartmentDTO.class);
    }

    public Boolean deleteDepartmentById(DepartmentDTO departmentDTO) {
        Long departmentId = departmentDTO.getId();
        Boolean exits = departmentRepository.existsById(departmentId);
        if(!exits) return false;
        else departmentRepository.deleteById(departmentId);
        return true;
    }
}


