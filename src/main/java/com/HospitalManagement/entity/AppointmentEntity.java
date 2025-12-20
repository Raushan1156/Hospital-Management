package com.HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Appointment")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Instant appointmentTime;
    String reason;
    String status;

//    @ManyToOne
//    @JoinColumn(name = "patient_id")
//    PatientEntity patientEntity;  // owning side

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    DoctorEntity doctorEntity;  // owning side
}
