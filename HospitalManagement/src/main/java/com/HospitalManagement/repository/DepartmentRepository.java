package com.HospitalManagement.repository;

import com.HospitalManagement.dto.DepartmentDto;
import com.HospitalManagement.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
