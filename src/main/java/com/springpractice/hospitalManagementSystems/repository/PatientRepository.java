package com.springpractice.hospitalManagementSystems.repository;

import com.springpractice.hospitalManagementSystems.dto.BloodGroupStats;
import com.springpractice.hospitalManagementSystems.dto.CPatientInfo;
import com.springpractice.hospitalManagementSystems.dto.IPatientInfo;
import com.springpractice.hospitalManagementSystems.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

//    @Query("SELECT p.id, p.name, p.email from Patient p")
    @Query("select p.id as id, p.name as name, p.email as email from Patient p")
    List<IPatientInfo> getAllPatientsInfo();

    @Query("select new com.springpractice.hospitalManagementSystems.dto.CPatientInfo(p.id, p.name) " +
            "from Patient p")
    List<CPatientInfo> getAllPatientsInfoConcrete();

    @Query("select new com.springpractice.hospitalManagementSystems.dto.BloodGroupStats(p.bloodGroup, COUNT(p)) " +
            "from Patient p group by p.bloodGroup order by COUNT(p) DESC")
    List<BloodGroupStats> getBloodGroupStats();

//    For the below query to work we need to add @Transactional Annotation
    @Transactional // basically this will start a transaction at the database level or start a database transaction,
    // either all the operations occur or will not occur
    @Modifying  // Let the JPA Repository know that, yes this is supposed to modify the database.
    @Query("UPDATE Patient p set p.name = :name where p.id = :id")
    int updatePatientNameWithId(@Param("name") String name, @Param("id") Long id);

}
