package com.Group4.HospitalBedSystem.controller;

import com.Group4.HospitalBedSystem.dto.response.PaymentCallbackData;
import com.Group4.HospitalBedSystem.entity.AdmissionEntity;
import com.Group4.HospitalBedSystem.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AdmissionController {
    @Autowired
    private AdmissionService admissionService;

    @GetMapping("/api/v1/admissions")
    public ResponseEntity<?> getAllAdmissions(){
        return admissionService.getAdmissions();
    }

    @GetMapping("/api/v1/admissionById/{id}")
    public ResponseEntity<?> getAdmissionById(@PathVariable int id){
        return admissionService.getAdmissionById(id);
    }

    @PostMapping("/api/v1/addAdmission")
    public ResponseEntity<?> addAdmission(@RequestBody AdmissionEntity admissionEntity) {
        return admissionService.saveAdmission(admissionEntity);
    }

    //api payment callback
    @PostMapping("/api/v1/paymentCallback")
    public ResponseEntity<?> updateAdmissionFromPayment(@ModelAttribute PaymentCallbackData pay){
        return admissionService.updateAdmissionFromPayment(pay);
    }


    //updatePatientDischargeDate
    @PutMapping("/api/v1/updateAdmission")
    public ResponseEntity<?> updateAdmission(@RequestBody AdmissionEntity admissionEntity){
        return admissionService.updateAdmission(admissionEntity);
    }
}
