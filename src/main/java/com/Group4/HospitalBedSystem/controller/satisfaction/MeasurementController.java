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


    //    @GetMapping
//    public String getAllMeasurements(Model model) {
//        List<MeasurementEntity> measurements = measurementService.getAllMeasurements();
//        model.addAttribute("measurements", measurements);
//        return "/feedback/measurement/measurements";
//    }
//
//    @GetMapping("/add")
//    public String addMeasurementForm(Model model) {
//        model.addAttribute("measurement", new MeasurementEntity());
//        //model.addAttribute("categories", categoryService.getAllCategories());
//        return "/feedback/measurement/add-measurement";
//    }
//
//    @PostMapping
//    public String addMeasurement(@ModelAttribute MeasurementEntity measurement) {
//        measurementService.saveMeasurement(measurement);
//        return "redirect:/measurements";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String editMeasurementForm(@PathVariable int id, Model model) {
//        MeasurementEntity measurement = measurementService.getMeasurementById(id);
//        model.addAttribute("measurement", measurement);
//       // model.addAttribute("categories", categoryService.getAllCategories());
//        return "/feedback/measurement/edit-measurement";
//    }
//
//    @PostMapping("/edit/{id}")
//    public String editMeasurement(@PathVariable int id, @ModelAttribute MeasurementEntity measurement) {
//        measurement.setId(id);
//        measurementService.saveMeasurement(measurement);
//        return "redirect:/measurements";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteMeasurement(@PathVariable int id) {
//        measurementService.deleteMeasurement(id);
//        return "redirect:/measurements";
//    }
//
//    @GetMapping("/measurements/byCategory/{categoryId}")
//    @ResponseBody
//    public List<MeasurementEntity> getMeasurementsByCategory(@PathVariable int categoryId) {
//        return measurementService.getMeasurementsByCategory(categoryId);
//    }

}