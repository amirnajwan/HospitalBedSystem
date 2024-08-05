package com.Group4.HospitalBedSystem.service.satisfaction;

import com.Group4.HospitalBedSystem.entity.satification.*;
import com.Group4.HospitalBedSystem.repository.satisfaction.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {
    @Autowired
    private MeasurementRepository measurementRepository;

    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    public Measurement getMeasurementById(Long id) {
        return measurementRepository.findById(id).orElse(null);
    }

    public List<Measurement> getMeasurementsByCategoryId(Long categoryId) {
        return measurementRepository.findByCategoryId(categoryId);
    }

    public Measurement saveMeasurement(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    public void deleteMeasurement(Long id) {
        measurementRepository.deleteById(id);
    }
    public List<Measurement> getMeasurementsByCategory(Long categoryId) {
        return measurementRepository.findByCategoryId(categoryId);
    }
}
