package com.datasperling.SQLPatientSystem.patient;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Patient {
    @Id
    @SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_sequence"
    )
    private Long id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String address;
    private String postcode;
    private String allergies;
    private boolean diabetic;

    public Patient() {
    }

    public Patient(Long id,
                   String firstName,
                   String secondName,
                   String lastName,
                   String gender,
                   LocalDate dateOfBirth,
                   String address,
                   String postcode,
                   String allergies,
                   boolean diabetic) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.postcode = postcode;
        this.allergies = allergies;
        this.diabetic = diabetic;
    }

    public Patient(String firstName,
                   String secondName,
                   String lastName,
                   String gender,
                   LocalDate dateOfBirth,
                   String address,
                   String postcode,
                   String allergies,
                   boolean diabetic) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.postcode = postcode;
        this.allergies = allergies;
        this.diabetic = diabetic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public boolean isDiabetic() {
        return diabetic;
    }

    public void setDiabetic(boolean diabetic) {
        this.diabetic = diabetic;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", allergies='" + allergies + '\'' +
                ", diabetic=" + diabetic +
                '}';
    }
}
