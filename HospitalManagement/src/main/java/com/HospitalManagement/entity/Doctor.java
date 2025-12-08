package com.HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String specialization;
    String email;

    @CreationTimestamp
    Instant createdAt;

    @OneToMany(mappedBy = "doctor")
//    @JoinColumn(name = "appointment_id")
    List<Appointment> appointments = new ArrayList<>(); // inverse side

    @ManyToMany
    List<Department> departments = new ArrayList<>();

    @OneToOne(mappedBy = "doctor")
//    @JoinColumn(name = "department_id")
    Department department; // inverse side
}
