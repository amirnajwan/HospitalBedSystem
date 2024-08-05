package com.Group4.HospitalBedSystem.controller.satisfaction;

import com.Group4.HospitalBedSystem.entity.satification.*;
import com.Group4.HospitalBedSystem.service.satisfaction.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/measurements")
public class MeasurementController {
    @Autowired
    private MeasurementService measurementService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getAllMeasurements(Model model) {
        List<Measurement> measurements = measurementService.getAllMeasurements();
        model.addAttribute("measurements", measurements);
        return "/feedback/measurement/measurements";
    }

    @GetMapping("/add")
    public String addMeasurementForm(Model model) {
        model.addAttribute("measurement", new Measurement());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "/feedback/measurement/add-measurement";
    }

    @PostMapping
    public String addMeasurement(@ModelAttribute Measurement measurement) {
        measurementService.saveMeasurement(measurement);
        return "redirect:/measurements";
    }

    @GetMapping("/edit/{id}")
    public String editMeasurementForm(@PathVariable Long id, Model model) {
        Measurement measurement = measurementService.getMeasurementById(id);
        model.addAttribute("measurement", measurement);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "/feedback/measurement/edit-measurement";
    }

    @PostMapping("/edit/{id}")
    public String editMeasurement(@PathVariable Long id, @ModelAttribute Measurement measurement) {
        measurement.setId(id);
        measurementService.saveMeasurement(measurement);
        return "redirect:/measurements";
    }

    @GetMapping("/delete/{id}")
    public String deleteMeasurement(@PathVariable Long id) {
        measurementService.deleteMeasurement(id);
        return "redirect:/measurements";
    }

    @GetMapping("/measurements/byCategory/{categoryId}")
    @ResponseBody
    public List<Measurement> getMeasurementsByCategory(@PathVariable Long categoryId) {
        return measurementService.getMeasurementsByCategory(categoryId);
    }

}