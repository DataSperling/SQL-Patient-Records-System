package com.datasperling.SQLPatientSystem.patient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PatientRepositoryTest {

    @Autowired
    private PatientRepository underTest;

    @Test
    void itShouldFindPatientByFirstName() {
        //given
        String firstName = "Nikoli";
        Patient patient = new Patient(
                "Nikoli",
                "Grigoriev",
                "Mendelson",
                "MALE",
                LocalDate.of(1923, Month.APRIL, 27),
                "187 Red Square",
                "01001",
                "Aspirin",
                false
        );
        underTest.save(patient);

        // when
        boolean expected = underTest.selectExistsByFirstName(firstName);

        // then
        assertThat(expected).isTrue();
    }

    @Test
    void findPatientByLastName() {
    }

    @Test
    void findPatientByAddress() {
    }
}