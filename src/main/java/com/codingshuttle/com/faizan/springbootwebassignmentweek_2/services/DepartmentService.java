package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.services;

import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.dto.DepartmentDTO;
import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.entities.DepartmentEntity;
import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.exceptions.ResourceNotFoundException;
import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<DepartmentDTO> getDepartment(Long id) {
        return departmentRepository.findById(id).map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class));
//        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElse(null);
//        return modelMapper.map(departmentEntity,DepartmentDTO.class);
    }


    public DepartmentDTO createDepartment(DepartmentDTO inputDepartment) {
        //setting the timeStamp
        inputDepartment.setCreatedAt(LocalDate.now());
        //convert
        DepartmentEntity toSaveDepartment = modelMapper.map(inputDepartment, DepartmentEntity.class);
        DepartmentEntity departmentEntity = departmentRepository.save(toSaveDepartment);
        return modelMapper.map(departmentEntity, DepartmentDTO.class);
    }

    public boolean isExistsByDepartment(Long departmentId) {
        boolean exists = departmentRepository.existsById(departmentId);
        if (!exists) throw new ResourceNotFoundException("The Department with requested id: "+ departmentId +" is not found");
        return true;
    }

    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO) {
        Long departmentId = departmentDTO.getId();
        isExistsByDepartment(departmentId);
//       DepartmentEntity findingDepartment = departmentRepository.findById(departmentId).orElse(null);
        DepartmentEntity conversionToEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        conversionToEntity.setId(departmentId);
        DepartmentEntity toSaveEntity = departmentRepository.save(conversionToEntity);
        return modelMapper.map(conversionToEntity, DepartmentDTO.class);
    }

    public Boolean deleteDepartmentById(DepartmentDTO departmentDTO) {
        Long departmentId = departmentDTO.getId();
        isExistsByDepartment(departmentId);
//        Boolean exits = departmentRepository.existsById(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }
}


