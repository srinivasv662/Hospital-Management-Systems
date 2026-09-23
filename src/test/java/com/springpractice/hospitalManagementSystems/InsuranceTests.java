package com.springpractice.hospitalManagementSystems;

import com.springpractice.hospitalManagementSystems.entity.Appointment;
import com.springpractice.hospitalManagementSystems.entity.Insurance;
import com.springpractice.hospitalManagementSystems.service.AppointmentService;
import com.springpractice.hospitalManagementSystems.service.InsuranceService;
import com.springpractice.hospitalManagementSystems.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private PatientService patientService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testAssignInsuranceToPatient() {
        Insurance insurance = Insurance.builder()
                .provider("HDFC Ergo")
                .policyNumber("HDFC_23G")
                .validUntil(LocalDate.of(2030, 1, 1))
                .build();

        var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance, 1L);

        System.out.println(updatedInsurance);

        patientService.deletePatient(1L);
    }

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 11, 1, 14, 0, 0))
                .reason("Cancer")
                .build();

        var updatedAppointment = appointmentService.createNewAppointment(appointment, 1L, 2L);

        System.out.println(updatedAppointment);

        patientService.deletePatient(1L);
    }

}
