package com.datasperling.SQLPatientSystem.patient;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class PatientService {

    public List<Patient> getPatients() {
        return List.of(
                new Patient(
                        1L,
                        "Mariam",
                        null,
                        "Smith",
                        "FEMALE",
                        LocalDate.of(2000, Month.JANUARY, 5),
                        "15 winchester av",
                        null,
                        null,
                        false
                )
        );
    }
}
