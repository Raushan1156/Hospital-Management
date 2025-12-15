package com.HospitalManagement.dto;

import com.HospitalManagement.entity.AppointmentEntity;
import com.HospitalManagement.entity.InsuranceEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientDto {

    Long id;
    String name;
    String gender;
    Date birthDate;
    String email;
    String bloodGroup;

    @CreationTimestamp
    Instant createdDate;
}
