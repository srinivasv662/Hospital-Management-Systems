package com.springpractice.hospitalManagementSystems.service;

import com.springpractice.hospitalManagementSystems.entity.Patient;
import com.springpractice.hospitalManagementSystems.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.naming.Context;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public void testPatientTransaction() {
        Patient p1 = patientRepository.findById(1L).orElseThrow();
        Patient p2 = patientRepository.findById(1L).orElseThrow();

        System.out.println(p1 + " " + p2);
        System.out.println(p1 == p2);

        p1.setName("Random Name");  // You have dirtied this patient entity which is in persistent context
    }

    // without Transactional Context
//    Hibernate: select p1_0.id,p1_0.birth_date,p1_0.blood_group,p1_0.created_at,p1_0.email,p1_0.gender,p1_0.name from patient p1_0 where p1_0.id=?
//    Hibernate: select p1_0.id,p1_0.birth_date,p1_0.blood_group,p1_0.created_at,p1_0.email,p1_0.gender,p1_0.name from patient p1_0 where p1_0.id=?
//    Patient(id=1, name=Aarav Sharma, birthDate=1990-05-10, email=aarav.sharma@example.com, gender=MALE, bloodGroup=O_POSITIVE, createdAt=2026-09-22T10:56:24.482763) Patient(id=1, name=Aarav Sharma, birthDate=1990-05-10, email=aarav.sharma@example.com, gender=MALE, bloodGroup=O_POSITIVE, createdAt=2026-09-22T10:56:24.482763)
//    false

//    with Transactional Context
//    Hibernate: select p1_0.id,p1_0.birth_date,p1_0.blood_group,p1_0.created_at,p1_0.email,p1_0.gender,p1_0.name from patient p1_0 where p1_0.id=?
//    Patient(id=1, name=Aarav Sharma, birthDate=1990-05-10, email=aarav.sharma@example.com, gender=MALE, bloodGroup=O_POSITIVE, createdAt=2026-09-22T10:57:45.638670) Patient(id=1, name=Aarav Sharma, birthDate=1990-05-10, email=aarav.sharma@example.com, gender=MALE, bloodGroup=O_POSITIVE, createdAt=2026-09-22T10:57:45.638670)
//            true

//
//    With p1.setName("Random Name"); --> Dirtied the entity data.
//    Hibernate: select p1_0.id,p1_0.birth_date,p1_0.blood_group,p1_0.created_at,p1_0.email,p1_0.gender,p1_0.name from patient p1_0 where p1_0.id=?
//    Patient(id=1, name=Aarav Sharma, birthDate=1990-05-10, email=aarav.sharma@example.com, gender=MALE, bloodGroup=O_POSITIVE, createdAt=2026-09-22T10:59:49.206467) Patient(id=1, name=Aarav Sharma, birthDate=1990-05-10, email=aarav.sharma@example.com, gender=MALE, bloodGroup=O_POSITIVE, createdAt=2026-09-22T10:59:49.206467)
//            true
//    Hibernate: update patient set birth_date=?,blood_group=?,email=?,gender=?,name=? where id=?

}
