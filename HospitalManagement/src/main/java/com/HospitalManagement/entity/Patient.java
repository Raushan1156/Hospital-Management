package com.HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.AccessType;

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
public class Patient {

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

    @OneToOne(mappedBy = "patient")
//    @JoinColumn(name = "policy_id")
    Insurance insurance; // inverse side

    @OneToMany(mappedBy = "patient")
//    @JoinColumn(name = "appointment_id")
    List<Appointment> appointment = new ArrayList<>(); // inverse side
}
