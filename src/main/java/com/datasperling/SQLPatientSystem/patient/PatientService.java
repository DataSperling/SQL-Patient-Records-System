package com.datasperling.SQLPatientSystem.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public void addPatient(Patient patient) {
        Optional<Patient> patientOptional = patientRepository.findPatientByLastName(patient.getLastName());

        if (patientOptional.isPresent()) {
            throw new IllegalStateException("Error: patient already exists in database");
        }
        patientRepository.save(patient);


        System.out.println(patient);

    }
}
