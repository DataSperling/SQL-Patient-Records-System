package com.datasperling.SQLPatientSystem.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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
    }


    public void deletePatient(Long patientId) {
        boolean exists = patientRepository.existsById(patientId);

        if (!exists) {
            throw new IllegalStateException("patient with Id: " + patientId + " does not exist");
        }
        patientRepository.deleteById(patientId);
    }


    @Transactional
    public void updatePatient(Long patientId,
                              String firstName,
                              String lastName,
                              String address) {
        Patient patient = patientRepository.findById(patientId).
                orElseThrow( () -> new IllegalStateException(
                "Patient with Id: " + patientId + " does not exist"
        ));

        if (firstName != null &&
            firstName.length() > 0 &&
            !Objects.equals(patient.getFirstName(), firstName)) {
            patient.setFirstName(firstName);
        }

        if (lastName != null &&
            lastName.length() > 0 &&
            !Objects.equals(patient.getLastName(), lastName)) {
            Optional<Patient> patientOptionalFirstName = patientRepository.findPatientByFirstName(firstName);
            Optional<Patient> patientOptionalLastName = patientRepository.findPatientByFirstName(lastName);
            Optional<Patient> findPatientByAddress = patientRepository.findPatientByAddress(address);

            if (patientOptionalFirstName.isPresent() &&
                    patientOptionalLastName.isPresent() &&
                    findPatientByAddress.isPresent() ) {
                throw new IllegalStateException("Patient entry may be duplicate");
            }
            patient.setLastName(lastName);
        }
    }
}
