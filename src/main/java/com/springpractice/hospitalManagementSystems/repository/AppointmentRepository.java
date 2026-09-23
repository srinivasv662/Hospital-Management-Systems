package com.springpractice.hospitalManagementSystems.repository;

import com.springpractice.hospitalManagementSystems.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}