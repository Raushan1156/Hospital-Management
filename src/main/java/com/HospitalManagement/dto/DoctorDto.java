package com.HospitalManagement.dto;

import com.HospitalManagement.entity.AppointmentEntity;
import com.HospitalManagement.entity.DepartmentEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorDto {
    Long id;
    String name;
    String specialization;
    String email;

    @CreationTimestamp
    Instant createdAt;
}
