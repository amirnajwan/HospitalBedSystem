package com.Group4.HospitalBedSystem.repository;

import com.Group4.HospitalBedSystem.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {
    PatientEntity findPatientByName(String name);
    PatientEntity findPatientByPatientId(String patientId);
}
