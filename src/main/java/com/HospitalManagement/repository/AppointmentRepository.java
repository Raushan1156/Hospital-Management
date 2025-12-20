package com.HospitalManagement.repository;

import com.HospitalManagement.dto.AppointmentDto;
import com.HospitalManagement.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
}
