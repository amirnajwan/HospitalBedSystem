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
    @PostMapping("/addPatient")
    public ResponseEntity<?> addPatient(@RequestBody PatientEntity patient) {
        return service.savePatient(patient);
    }

    //Get
    @GetMapping("/patients")
    public ResponseEntity<?> getAllPatients(){
        return service.getPatients();
    }

    @GetMapping("/patientById/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable int id){
        return service.getPatientById(id);
    }

    @GetMapping("/patientByName/{name}")
    public ResponseEntity<?> getPatientByName(@PathVariable String name){
        return service.getPatientByName(name);
    }

    //Update
    @PutMapping("/updatePatient")
    public ResponseEntity<?> updatePatient(@RequestBody PatientEntity patient){
        return service.updatePatient(patient);
    }

    //Delete
    @DeleteMapping("/deletePatient/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable int id){
        return service.deletePatient(id);
    }
}
