package com.springpractice.hospitalManagementSystems.repository;

import com.springpractice.hospitalManagementSystems.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}