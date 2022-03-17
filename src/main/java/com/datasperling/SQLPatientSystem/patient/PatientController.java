package com.datasperling.SQLPatientSystem.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/patient")
public class PatientController {

    private final PatientService patientService;


    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }


    @PostMapping
    public void registerPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }


    @DeleteMapping(path = "{patientId}")
    public void deletePatient(@PathVariable("patientId") Long patientId) {
        patientService.deletePatient(patientId);
    }

    @PutMapping(path = "{patientId}")
    public void updatePatient(
            @PathVariable("patientId") Long patientId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String address) {
        patientService.updatePatient(patientId, firstName, lastName, address);
    }

}
