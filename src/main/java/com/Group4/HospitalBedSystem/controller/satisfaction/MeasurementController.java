package com.Group4.HospitalBedSystem.controller.satisfaction;

import com.Group4.HospitalBedSystem.entity.satification.*;
import com.Group4.HospitalBedSystem.service.satisfaction.*;
import com.Group4.HospitalBedSystem.dto.response.satisfication.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MeasurementController {
    @Autowired
    private MeasurementService measurementService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping ("/api/v1/measurements")
    public ResponseEntity<?> getAllMeasurements() {return measurementService.getMeasurements();}

    @PostMapping("/api/v1/addMeasurement")
    public ResponseEntity<?> addMeasurement(@RequestBody MeasurementResponse measurementResponse) {
        MeasurementEntity measurementEntity = new MeasurementEntity();
        measurementEntity.setName(measurementResponse.getName());

        int categoryId = measurementResponse.getCategoryId();
        return measurementService.saveMeasurements(measurementEntity, categoryId);
    }

    @PutMapping("/api/v1/updateMeasurement/{id}")
    public ResponseEntity<?> updateMeasurement(@PathVariable int id, @RequestBody MeasurementEntity measurementEntity) {
        measurementEntity.setId(id); // Ensure the entity has the correct ID
        return measurementService.updateMeasurements(measurementEntity);
    }
    @DeleteMapping ("/api/v1/deleteMeasurement/{id}")
    public ResponseEntity<?> deleteMeasurement(@PathVariable int id){
        return measurementService.deleteMeasurements(id);
    }
}