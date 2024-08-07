package com.Group4.HospitalBedSystem.service;

import com.Group4.HospitalBedSystem.dto.response.PatientResponse;
import com.Group4.HospitalBedSystem.entity.PatientEntity;
import com.Group4.HospitalBedSystem.entity.generator.PatientIdGenerator;
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
    @Autowired
    private PatientIdGenerator patientIdGenerator;

    // Post methods
    public ResponseEntity<?> savePatient(PatientEntity patient) {
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            if (patient != null) {
                String newPatientId = patientIdGenerator.generateNewPatientId();
                patient.setPatientId(newPatientId);
                if (repository.save(patient) != null) {
                    result.setSuccess(true);
                    result.setMessage("Added new patient.");
                    result.setData(patient);
                } else {
                    result.setMessage("Failed to add patient");
                }
                result.setData(patient);
                return ResponseEntity.ok(result);
            } else {
                result.setMessage("Failed to add patient");
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get methods
    public ResponseEntity<?> getPatients() {
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        List<PatientEntity> patients = repository.findAll();
        try {
            if (patients != null) {
                result.setSuccess(true);
                result.setMessage("Patient found.");
                List<PatientResponse> patientList = new ArrayList<>();
                for (PatientEntity patient : patients) {
                    patientList.add(mapPatientEntityToPatientDetail(patient));
                }
                result.setData(patientList);
            } else {
                result.setMessage("Patient not found.");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getPatientById(int id) {
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            PatientEntity patient = repository.findById(id).orElse(null);
            if (patient != null) {
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

    public ResponseEntity<?> getPatientByName(String name) {
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            PatientEntity patient = repository.findPatientByName(name);
            if (patient != null) {
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

    // Delete method
    public ResponseEntity<?> deletePatient(int id) {
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            repository.deleteById(id);
            result.setSuccess(true);
            result.setMessage("Deleted patient with id : " + id);
        } catch (Exception e) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<?> updatePatientDischargeDate(PatientEntity patient) {
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            PatientEntity existPatient = repository.findById(patient.getId()).orElse(null);
            if (existPatient != null) {
                existPatient.setId(patient.getId());
                existPatient.setDischargeDate(patient.getDischargeDate());
                if (repository.save(existPatient) != null) {
                    result.setSuccess(true);
                    result.setMessage("Successfully update a patient.");
                    result.setData(existPatient);
                } else {
                    result.setMessage("Failed to update a patient.");
                }
            } else {
                result.setMessage("Patient not found.");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public PatientResponse mapPatientEntityToPatientDetail(PatientEntity patientEntity) {
        PatientResponse data = new PatientResponse();
        data.setId(patientEntity.getId());
        data.setPatientId(patientEntity.getPatientId());
        data.setName(patientEntity.getName());
        data.setAge(patientEntity.getAge());
        data.setGender(patientEntity.getGender());
        data.setMaritalStatus(patientEntity.getMaritalStatus());
        data.setEmploymentStatus(patientEntity.getEmploymentStatus());
        data.setSector(patientEntity.getSector());
        data.setRegisterDate(patientEntity.getRegisterDate());
        data.setAdmissionDate(patientEntity.getAdmissionDate());
        data.setDischargeDate(patientEntity.getDischargeDate());
        return data;
    }
}
