package com.datasperling.SQLPatientSystem.patient;

import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class PatientService {

    // want this to come from database
    @GetMapping
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
