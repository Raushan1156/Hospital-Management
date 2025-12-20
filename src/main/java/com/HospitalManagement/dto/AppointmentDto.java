package com.HospitalManagement.dto;

import com.HospitalManagement.entity.DoctorEntity;
import com.HospitalManagement.entity.PatientEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentDto {

    Long id;
    Instant appointmentTime;
    String reason;
    String status;
    PatientEntity patientEntity;
    DoctorEntity doctorEntity;
}
