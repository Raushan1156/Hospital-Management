package com.HospitalManagement.entity;

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
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Patient")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String gender;
    Date birthDate;
    String email;
    String bloodGroup;

    @CreationTimestamp
    Instant createdDate;

    @OneToOne(mappedBy = "patientEntity")
//    @JoinColumn(name = "policy_id")
    InsuranceEntity insuranceEntity; // inverse side

    @OneToMany(mappedBy = "patientEntity")
//    @JoinColumn(name = "appointment_id")
    List<AppointmentEntity> appointmentEntity = new ArrayList<>(); // inverse side
}
