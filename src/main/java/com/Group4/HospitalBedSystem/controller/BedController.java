package com.Group4.HospitalBedSystem.controller;

import com.Group4.HospitalBedSystem.entity.BedEntity;
import com.Group4.HospitalBedSystem.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BedController {
    @Autowired
    private BedService service;

    //Post
    @PostMapping("/addBed")
    public ResponseEntity<?> addBed(@RequestBody BedEntity bed) {
        return service.saveBed(bed);
    }

    //Get
    @GetMapping("/beds")
    public ResponseEntity<?> getAllBeds(){
        return service.getBeds();
    }

    @GetMapping("/bedById/{id}")
    public ResponseEntity<?> getBedById(@PathVariable int id){
        return service.getBedById(id);
    }

    @GetMapping("/bedByName/{name}")
    public ResponseEntity<?> getBedByName(@PathVariable String name){
        return service.getBedByName(name);
    }

    //Update
    @PutMapping("/updateBed")
    public ResponseEntity<?> updateBed(@RequestBody BedEntity bed){
        return service.updateBed(bed);
    }

    //Delete
    @DeleteMapping("/deleteBed/{id}")
    public ResponseEntity<?> deleteBed(@PathVariable int id){
        return service.deleteBed(id);
    }
}
