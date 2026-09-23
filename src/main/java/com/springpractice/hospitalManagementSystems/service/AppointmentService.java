package com.springpractice.hospitalManagementSystems.service;

import com.springpractice.hospitalManagementSystems.entity.Appointment;
import com.springpractice.hospitalManagementSystems.entity.Doctor;
import com.springpractice.hospitalManagementSystems.entity.Patient;
import com.springpractice.hospitalManagementSystems.repository.AppointmentRepository;
import com.springpractice.hospitalManagementSystems.repository.DoctorRepository;
import com.springpractice.hospitalManagementSystems.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final DoctorRepository doctorRepository;

    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long patientId, Long doctorId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();  // in persistent state already
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();  // in persistent state already

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);  // from transient state to persistent state

        return appointment;
    }



}
