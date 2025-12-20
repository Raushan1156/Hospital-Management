package com.HospitalManagement.dto;

import com.HospitalManagement.entity.PatientEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InsuranceDto {

    Long id;
    String policyNumber;
    String provider;
    Date validUntil;
    @CreationTimestamp
    Instant createdAt;
    PatientEntity patientEntity;
}
