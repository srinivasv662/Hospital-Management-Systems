package com.springpractice.hospitalManagementSystems.service;

import com.springpractice.hospitalManagementSystems.entity.Insurance;
import com.springpractice.hospitalManagementSystems.entity.Patient;
import com.springpractice.hospitalManagementSystems.repository.InsuranceRepository;
import com.springpractice.hospitalManagementSystems.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;

    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance);  // dirty patient

        insurance.setPatient(patient); // optional

        return insurance;
    }
}
