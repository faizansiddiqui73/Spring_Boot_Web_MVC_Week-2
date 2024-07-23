package com.codingshuttle.com.faizan.springbootwebassignmentweek_2.repositories;

import com.codingshuttle.com.faizan.springbootwebassignmentweek_2.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

}
