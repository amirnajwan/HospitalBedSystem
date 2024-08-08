package com.Group4.HospitalBedSystem.service.satisfaction;

import com.Group4.HospitalBedSystem.dto.response.satisfication.CategoryResponse;
import com.Group4.HospitalBedSystem.dto.response.satisfication.MeasurementResponse;
import com.Group4.HospitalBedSystem.entity.satification.*;
import com.Group4.HospitalBedSystem.repository.satisfaction.*;
import com.Group4.HospitalBedSystem.service.general.SuccessAndDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeasurementService {
    @Autowired
    private MeasurementRepository measurementRepository;

    public ResponseEntity<?> getMeasurements(){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        List<MeasurementEntity> measurementEntities = measurementRepository.findAll();
        if(measurementEntities!=null){
            result.setSuccess(true);
            result.setMessage("Categories list found");
            List<MeasurementResponse> measurementResponseList = new ArrayList<>();
            for(MeasurementEntity measurement: measurementEntities)
            {
                measurementResponseList.add(mapMeasurementEntityToMeasurementDetail(measurement));
            }
            result.setData(measurementResponseList);
            return ResponseEntity.ok(result);
        }else{
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }//end if else statement
    }//end getMeasurements()

    // Post methods
    public ResponseEntity<?> saveMeasurements(MeasurementEntity measurementEntity){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            if (measurementEntity != null) {
                if (measurementRepository.save(measurementEntity) != null) {
                    result.setSuccess(true);
                    result.setMessage("Added new a category");
                    result.setData(measurementEntity);
                } else {
                    result.setMessage("Failed to add a measurement");
                }
                System.out.println("test");
                result.setData(measurementEntity);
                return ResponseEntity.ok(result);
            } else {
                result.setMessage("Failed to add a measurement");
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        } catch (Exception e) {
            result.setMessage("Failed to add a measurement : " + e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }//end saveCategory

    public MeasurementResponse mapMeasurementEntityToMeasurementDetail (MeasurementEntity measurementEntity){
        MeasurementResponse data = new MeasurementResponse();
        data.setId(measurementEntity.getId()); //data 1
        data.setName(measurementEntity.getName()); //data 2
        if (measurementEntity.getCategory() != null) {
            data.setCategoryId(measurementEntity.getCategory().getId()); // Extract the id from CategoryEntity // data 3
        } else {
            data.setCategoryId(0); // Handle the case where category might be null
        }
        return data;
    }//end mapMeasurementEntityToMeasurementDetail
    public ResponseEntity<?> updateMeasurements(MeasurementEntity measurementEntity) {
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            MeasurementEntity existMeasurement = measurementRepository.findById(measurementEntity.getId()).orElse(null);
            if (existMeasurement != null) {
                existMeasurement.setName(measurementEntity.getName());
                measurementRepository.save(existMeasurement); // Save the updated category
                result.setSuccess(true);
                result.setMessage("Successfully updated the measurement");
                result.setData(existMeasurement);
            } else {
                result.setSuccess(false);
                result.setMessage("measurement not found");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("An error occurred: " + e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<?> deleteMeasurements(int measurementId) {
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            measurementRepository.deleteById(measurementId);
            result.setMessage("Deleted a measurement with id : " + measurementId);
            result.setSuccess(true);
        } catch (Exception e) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(result);
    }//end deleteMeasurements



//    public List<MeasurementEntity> getAllMeasurements() {
//        return measurementRepository.findAll();
//    }
//
//    public MeasurementEntity getMeasurementById(int id) {
//        return measurementRepository.findById(id).orElse(null);
//    }
//
//    public List<MeasurementEntity> getMeasurementsByCategoryId(int categoryId) {
//        return measurementRepository.findByCategoryId(categoryId);
//    }
//
//    public MeasurementEntity saveMeasurement(MeasurementEntity measurement) {
//        return measurementRepository.save(measurement);
//    }
//
//    public void deleteMeasurement(int id) {
//        measurementRepository.deleteById(id);
//    }
//    public List<MeasurementEntity> getMeasurementsByCategory(int categoryId) {
//        return measurementRepository.findByCategoryId(categoryId);
//    }


}
