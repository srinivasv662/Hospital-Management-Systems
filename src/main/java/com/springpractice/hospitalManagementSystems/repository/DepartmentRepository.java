package com.springpractice.hospitalManagementSystems.repository;

import com.springpractice.hospitalManagementSystems.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}