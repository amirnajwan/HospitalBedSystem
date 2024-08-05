package com.Group4.HospitalBedSystem.service;

import com.Group4.HospitalBedSystem.dto.response.PatientResponse;
import com.Group4.HospitalBedSystem.entity.PatientEntity;
import com.Group4.HospitalBedSystem.repository.PatientRepository;
import com.Group4.HospitalBedSystem.service.general.SuccessAndDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repository;

    //Post methods
    public ResponseEntity<?> savePatient(PatientEntity patient){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try{
            if (patient != null) {
                if (repository.save(patient) != null) {
                    result.setSuccess(true);
                    result.setMessage("Added new patient.");
                    result.setData(patient);
                } else {
                    result.setMessage("Failed to add patient");
                }
                System.out.println("test from PatientService Class.");
                result.setData(patient);
                return ResponseEntity.ok(result);
            } else {
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            result.setMessage(e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Get methods
    public ResponseEntity<?> getPatients(){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        List<PatientEntity> patients = new ArrayList<>();
        try {
            patients = repository.findAll();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (patients != null){
            result.setSuccess(true);
            result.setMessage("Patient found.");
            List<PatientResponse> patientList = new ArrayList<>();
            for (PatientEntity patient : patients) {
                patientList.add(mapPatientEntityToPatientDetail(patient));
            }
            result.setData(patientList);
            return ResponseEntity.ok(result);
        } else {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getPatientById(int id){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            PatientEntity patient = repository.findById(id).orElse(null);
            if (patient != null){
                result.setSuccess(true);
                result.setMessage("Patient found.");
                result.setData(this.mapPatientEntityToPatientDetail(patient));
            } else {
                result.setMessage("Patient not found.");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e){
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getPatientByName(String name){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            PatientEntity patient = repository.findPatientByName(name);
            if (patient != null){
                result.setSuccess(true);
                result.setMessage("Patient found.");
                result.setData(this.mapPatientEntityToPatientDetail(patient));
            } else {
                result.setMessage("Patient not found.");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Delete method
    public ResponseEntity<?> deletePatient(int id){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            repository.deleteById(id);
            result.setSuccess(true);
            result.setMessage("Deleted patient with id : " + id);
        } catch (Exception e){
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(result);
    }

    //Update method
    public ResponseEntity<?> updatePatient(PatientEntity patient){
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            PatientEntity existPatient = repository.findById(patient.getId()).orElse(null);
            if (existPatient != null){
                existPatient.setName(patient.getName());
                existPatient.setAge(patient.getAge());
                existPatient.setMarital_status(patient.getMarital_status());
                existPatient.setEmployment_status(patient.getEmployment_status());
                existPatient.setSector(patient.getSector());
                if (repository.save(existPatient) != null){
                    result.setSuccess(true);
                    result.setMessage("Successfully update a patient.");
                    result.setData(existPatient);
                }else {
                    result.setMessage("Failed to update a patient.");
                }
            } else {
                result.setMessage("Patient not found.");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e){
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public PatientResponse mapPatientEntityToPatientDetail(PatientEntity patientEntity){
        PatientResponse data = new PatientResponse();
        data.setId(patientEntity.getId());
        data.setPatient_id(patientEntity.getPatient_id());
        data.setName(patientEntity.getName());
        data.setAge(patientEntity.getAge());
        data.setGender(patientEntity.getGender());
        data.setMarital_status(patientEntity.getMarital_status());
        data.setEmployment_status(patientEntity.getEmployment_status());
        data.setSector(patientEntity.getSector());
        return data;
    }
}
