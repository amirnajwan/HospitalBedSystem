package com.Group4.HospitalBedSystem.service;

import com.Group4.HospitalBedSystem.dto.response.AdmissionResponse;
import com.Group4.HospitalBedSystem.entity.AdmissionEntity;
import com.Group4.HospitalBedSystem.entity.PatientEntity;
import com.Group4.HospitalBedSystem.entity.generator.AdmissionIdGenerator;
import com.Group4.HospitalBedSystem.repository.AdmissionRepository;
import com.Group4.HospitalBedSystem.service.general.SuccessAndDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdmissionService {
    @Autowired
    private AdmissionRepository repository;
    @Autowired
    private AdmissionIdGenerator admissionIdGenerator;

    // Get methods
    public ResponseEntity<?> getAdmissions() {
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        List<AdmissionEntity> admissions = repository.findAll();
        try {
            if (admissions != null) {
                result.setSuccess(true);
                result.setMessage("Admission found.");
                List<AdmissionResponse> admissionList = new ArrayList<>();
                for (AdmissionEntity admission : admissions) {
                    admissionList.add(mapAdmissionEntityToAdmissionDetail(admission));
                }
                result.setData(admissionList);
            } else {
                result.setMessage("Admission not found.");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getAdmissionById(int id) {
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            AdmissionEntity admission = repository.findById(id).orElse(null);
            if (admission != null) {
                result.setSuccess(true);
                result.setMessage("Admission found.");
                result.setData(this.mapAdmissionEntityToAdmissionDetail(admission));
            } else {
                result.setMessage("Admission not found.");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Post methods
    public ResponseEntity<?> saveAdmission(AdmissionEntity admission) {
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            if (admission != null) {
                String newAdmissionId = admissionIdGenerator.generateNewAdmissionId();
                admission.setAdmissionId(newAdmissionId);
                if (repository.save(admission) != null) {
                    result.setSuccess(true);
                    result.setMessage("Added new admission.");
                    result.setData(admission);
                } else {
                    result.setMessage("Failed to add admission");
                }
                result.setData(admission);
                return ResponseEntity.ok(result);
            } else {
                result.setMessage("Failed to add admission");
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> updateAdmission(AdmissionEntity admission) {
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            AdmissionEntity existAdmission = repository.findById(admission.getId()).orElse(null);
            if (existAdmission != null) {
                existAdmission.setId(admission.getId());
                existAdmission.setPatientId(admission.getPatientId());
                existAdmission.setBedId(admission.getBedId());
                existAdmission.setDischargeBy(admission.getDischargeBy());
                existAdmission.setDischargeSummary(admission.getDischargeSummary());
                existAdmission.setDischargeDate(admission.getDischargeDate());
                existAdmission.setAmount(admission.getAmount());
                if (repository.save(existAdmission) != null) {
                    result.setSuccess(true);
                    result.setMessage("Successfully update a admission.");
                    result.setData(existAdmission);
                } else {
                    result.setMessage("Failed to update a admission.");
                }
            } else {
                result.setMessage("admission not found.");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    public AdmissionResponse mapAdmissionEntityToAdmissionDetail(AdmissionEntity admissionEntity) {
        AdmissionResponse data = new AdmissionResponse();
        data.setId(admissionEntity.getId());
        data.setAdmissionId(admissionEntity.getAdmissionId());
        data.setPatientId(admissionEntity.getPatientId());
        data.setBedId(admissionEntity.getBedId());
        data.setDiagnosis(admissionEntity.getDiagnosis());
        data.setDischargeBy(admissionEntity.getDischargeBy());
        data.setDischargeSummary(admissionEntity.getDischargeSummary());
        data.setAdmissionDate(admissionEntity.getAdmissionDate());
        data.setDischargeDate(admissionEntity.getDischargeDate());
        data.setPaid(admissionEntity.isPaid());
        data.setAmount(admissionEntity.getAmount());
        data.setTransactionId(admissionEntity.getTransactionId());
        data.setRateBed(admissionEntity.getRateBed());
        return data;
    }
}
