package com.Group4.HospitalBedSystem.service.satisfaction;

import com.Group4.HospitalBedSystem.dto.response.satisfication.MeasurementResponse;
import com.Group4.HospitalBedSystem.entity.satification.*;
import com.Group4.HospitalBedSystem.repository.satisfaction.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {
    @Autowired
    private MeasurementRepository measurementRepository;

    public List<MeasurementEntity> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    public MeasurementEntity getMeasurementById(int id) {
        return measurementRepository.findById(id).orElse(null);
    }

    public List<MeasurementEntity> getMeasurementsByCategoryId(int categoryId) {
        return measurementRepository.findByCategoryId(categoryId);
    }

    public MeasurementEntity saveMeasurement(MeasurementEntity measurement) {
        return measurementRepository.save(measurement);
    }

    public void deleteMeasurement(int id) {
        measurementRepository.deleteById(id);
    }
    public List<MeasurementEntity> getMeasurementsByCategory(int categoryId) {
        return measurementRepository.findByCategoryId(categoryId);
    }

    public MeasurementResponse mapMeasurementEntityToMeasurementDetail (MeasurementEntity measurementEntity){
        MeasurementResponse data = new MeasurementResponse();
        data.setId(measurementEntity.getId());
        data.setName(measurementEntity.getName());
        if (measurementEntity.getCategory() != null) {
            data.setCategoryId(measurementEntity.getCategory().getId()); // Extract the id from CategoryEntity
        } else {
            data.setCategoryId(0); // Handle the case where category might be null
        }
        return data;
    }
}
