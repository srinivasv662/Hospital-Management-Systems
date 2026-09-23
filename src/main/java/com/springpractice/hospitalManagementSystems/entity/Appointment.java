package com.springpractice.hospitalManagementSystems.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 100)
    private String reason;

//    @ManyToOne(fetch = FetchType.LAZY), instead add @ToString.Exclude
    @ManyToOne // owning side
    @JoinColumn(nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private Patient patient;

//    @ManyToOne(fetch = FetchType.LAZY), instead add @ToString.Exclude
    @ManyToOne
    @JoinColumn(nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private Doctor doctor;

    // @JsonIgnore --> is needed when mapping to DTO, then this json type will not be added. Or else you can
    // use DTO class to return in the response.

}
