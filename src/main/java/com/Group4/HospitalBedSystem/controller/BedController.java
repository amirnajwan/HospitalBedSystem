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
    @PostMapping("/api/v1/registerBed")
    public ResponseEntity<?> addBed(@RequestBody BedEntity bed) {
        return service.saveBed(bed);
    }

    //Get
    @GetMapping("/api/v1/beds")
    public ResponseEntity<?> getAllBeds(){
        return service.getBeds();
    }

    @GetMapping("/api/v1/bedByBedTypeId/{bedTypeId}")
    public ResponseEntity<?> getBedByBedTypesId(@PathVariable String bedTypeId){
        return service.getBedByBedTypeId(bedTypeId);
    }

    @GetMapping("/api/v1/bedById/{id}")
    public ResponseEntity<?> getBedById(@PathVariable int id){
        return service.getBedById(id);
    }

    @GetMapping("/api/v1/bedByName/{name}")
    public ResponseEntity<?> getBedByName(@PathVariable String name){
        return service.getBedByName(name);
    }

    //Update
    @PutMapping("/api/v1/updateBed")
    public ResponseEntity<?> updateBed(@RequestBody BedEntity bed){
        return service.updateBed(bed);
    }

    //Delete
    @DeleteMapping("/api/v1/deleteBed/{id}")
    public ResponseEntity<?> deleteBed(@PathVariable int id){
        return service.deleteBed(id);
    }
}
