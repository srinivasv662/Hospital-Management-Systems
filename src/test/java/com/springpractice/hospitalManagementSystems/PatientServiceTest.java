package com.springpractice.hospitalManagementSystems;

import com.springpractice.hospitalManagementSystems.dto.BloodGroupStats;
import com.springpractice.hospitalManagementSystems.dto.CPatientInfo;
import com.springpractice.hospitalManagementSystems.dto.IPatientInfo;
import com.springpractice.hospitalManagementSystems.entity.Patient;
import com.springpractice.hospitalManagementSystems.repository.PatientRepository;
import com.springpractice.hospitalManagementSystems.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatient() {
//        List<Patient> patientList = patientRepository.findAll();
//
//        for(Patient p: patientList) {
//            System.out.println(p);
//        }

//        List<IPatientInfo> patientList = patientRepository.getAllPatientsInfo();
//
//        for(IPatientInfo p: patientList) {
////            System.out.println(p);  // Not working -> printing org.springframework.data.jpa.util.TupleBackedMap@4ad113d6 format
//            System.out.println(
//                "Id: " + p.getId() +
//                        ", Name: " + p.getName() +
//                        ", Email: " + p.getEmail()
//            );
//        }

//        List<CPatientInfo> patientList = patientRepository.getAllPatientsInfoConcrete();
//
//        for(CPatientInfo p: patientList) {
//            System.out.println(p);
//        }

//        List<BloodGroupStats> patientList = patientRepository.getBloodGroupStats();
//
//        for(BloodGroupStats p: patientList) {
//            System.out.println(p);
//        }


//        int rowsAffected = patientRepository.updatePatientNameWithId("Srinivas", 1L);
//        System.out.println(rowsAffected);
//
//        Patient patient = new Patient(); // currently this patient entity is in transient state
//        patientRepository.save(patient); // moves to persistent state

        patientService.testPatientTransaction();

    }

}
