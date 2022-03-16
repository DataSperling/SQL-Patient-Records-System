package com.datasperling.SQLPatientSystem.patient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PatientConfiguration {

        @Bean
        CommandLineRunner commandLineRunner(PatientRepository repository) {
            return args -> {
                Patient mariam = new Patient(
                        "Mariam",
                        null,
                        "Smith",
                        "FEMALE",
                        LocalDate.of(2000, Month.JANUARY, 5),
                        "15 winchester av",
                        null,
                        null,
                        false
                );

                Patient heinrich = new Patient(
                        "Heinrich",
                        null,
                        "Müller",
                        "MALE",
                        LocalDate.of(1976, Month.OCTOBER, 19),
                        "Bahnhoffplatz 436",
                        "50134",
                        "Sulfonamide",
                        true
                );

                repository.saveAll(
                        List.of(mariam, heinrich)
                );

            };
        }
}
