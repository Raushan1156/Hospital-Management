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
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @CreationTimestamp
    Instant createdAt;

    @OneToOne
    @JoinColumn(name = "head_doctor_id", nullable = false)
    Doctor doctor;  // owning side

    @ManyToMany(mappedBy = "departments")
    Set<Doctor> doctors = new HashSet<>();

}
