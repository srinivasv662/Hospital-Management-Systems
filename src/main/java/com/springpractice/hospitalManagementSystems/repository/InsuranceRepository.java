package com.springpractice.hospitalManagementSystems.repository;

import com.springpractice.hospitalManagementSystems.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}