package com.HospitalManagement.entity;

import com.HospitalManagement.enums.BloodGroup;
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
@ToString
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
    BloodGroup bloodGroup;

    @CreationTimestamp
    Instant createdDate;

    @OneToOne(mappedBy = "patientEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    InsuranceEntity insuranceEntity; // inverse side

//    @OneToMany(mappedBy = "patientEntity")
////    @JoinColumn(name = "appointment_id")
//    List<AppointmentEntity> appointmentEntity = new ArrayList<>(); // inverse side
}
