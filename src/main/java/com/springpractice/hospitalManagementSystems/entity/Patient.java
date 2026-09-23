package com.springpractice.hospitalManagementSystems.entity;

import com.springpractice.hospitalManagementSystems.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
@Setter
@Getter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthDate;

    private String email;

    private String gender;

    @Enumerated(value = EnumType.STRING)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    private LocalDateTime createdAt;

//    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_insurance", unique = true)
    private Insurance insurance;  // owning side

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)  // inverse side, Patient side is the Parent side in the data domain
    // when we delete the patient, it's appointments also should be deleted. inverse side is at the JPA end.
    private Set<Appointment> appointments = new HashSet<>();

}
