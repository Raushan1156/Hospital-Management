package com.HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Doctor")
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String specialization;
    String email;

    @CreationTimestamp
    Instant createdAt;

    @OneToMany(mappedBy = "doctorEntity")
//    @JoinColumn(name = "appointment_id")
    List<AppointmentEntity> appointmentEntities = new ArrayList<>(); // inverse side

    // owning side
    @ManyToMany
    @JoinTable(
            name = "doctor_department",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    Set<DepartmentEntity> departmentEntities = new HashSet<>();

    @OneToOne(mappedBy = "doctorEntity")
//    @JoinColumn(name = "department_id")
    DepartmentEntity departmentEntity; // inverse side
}
