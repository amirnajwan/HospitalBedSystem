package com.Group4.HospitalBedSystem.controller;

import com.Group4.HospitalBedSystem.entity.PatientEntity;
import com.Group4.HospitalBedSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {
    @Autowired
    private PatientService service;

    // Post
    @PostMapping("/api/v1/registerPatient")
    public ResponseEntity<?> addPatient(@RequestBody PatientEntity patient) {
        return service.savePatient(patient);
    }

    //Get
    @GetMapping("/api/v1/patients")
    public ResponseEntity<?> getAllPatients(){
        return service.getPatients();
    }

    @GetMapping("/api/v1/patientById/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable int id){
        return service.getPatientById(id);
    }

    @GetMapping("/api/v1/patientByName/{name}")
    public ResponseEntity<?> getPatientByName(@PathVariable String name){
        return service.getPatientByName(name);
    }

    //updatePatientDischargeDate
    @PutMapping("/api/v1/updatePatientDischargeDate")
    public ResponseEntity<?> updatePatientDischargeDate(@RequestBody PatientEntity patient){
        return service.updatePatientDischargeDate(patient);
    }

    //Delete
    @DeleteMapping("/api/v1/deletePatient/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable int id){
        return service.deletePatient(id);
    }
}
