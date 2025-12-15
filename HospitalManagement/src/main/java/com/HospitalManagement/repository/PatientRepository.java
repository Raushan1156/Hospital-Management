package com.HospitalManagement.repository;

import com.HospitalManagement.dto.PatientDto;
import com.HospitalManagement.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
}
