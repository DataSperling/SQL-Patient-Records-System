package com.datasperling.SQLPatientSystem;

import com.datasperling.SQLPatientSystem.patient.Patient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class SqlPatientSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(SqlPatientSystemApplication.class, args);
	}

	@GetMapping
	public List<Patient> hello() {
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
