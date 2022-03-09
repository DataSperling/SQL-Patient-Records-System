package com.datasperling.SQLPatientSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SqlPatientSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(SqlPatientSystemApplication.class, args);
	}



}
