package com.datasperling.SQLPatientSystem.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query ("SELECT s FROM Patient s WHERE s.firstName = ?1")
    Optional<Patient> findPatientByFirstName(String firstName);


    @Query ("SELECT s FROM Patient s WHERE s.firstName = ?1")
    Boolean selectExistsByFirstName(String firstName);

    @Query("SELECT s FROM Patient s WHERE s.lastName = ?1")
    Optional<Patient> findPatientByLastName(String lastName);

    @Query("SELECT s FROM Patient s WHERE s.address = ?1")
    Optional<Patient> findPatientByAddress(String address);
}
