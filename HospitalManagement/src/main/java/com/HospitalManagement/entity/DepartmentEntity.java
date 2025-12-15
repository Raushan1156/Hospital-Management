package com.HospitalManagement.entity;

import jakarta.persistence.*;
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
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Department")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @CreationTimestamp
    Instant createdAt;

    @OneToOne
    @JoinColumn(name = "head_doctor_id", nullable = false)
    DoctorEntity doctorEntity;  // owning side

    @ManyToMany(mappedBy = "departmentEntities")
    Set<DoctorEntity> doctorEntities = new HashSet<>();

}
