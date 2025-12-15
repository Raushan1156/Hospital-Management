package com.HospitalManagement.dto;

import com.HospitalManagement.entity.DoctorEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentDto {
    Long id;
    String name;
    @CreationTimestamp
    Instant createdAt;
    DoctorEntity doctorEntity;  // owning side
    Set<DoctorEntity> doctorEntities = new HashSet<>();
}
