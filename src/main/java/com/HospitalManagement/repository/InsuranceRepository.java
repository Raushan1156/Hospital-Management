package com.HospitalManagement.repository;

import com.HospitalManagement.dto.InsuranceDto;
import com.HospitalManagement.entity.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<InsuranceEntity, Long> {
}
