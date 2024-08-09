package com.Group4.HospitalBedSystem.repository;

import com.Group4.HospitalBedSystem.entity.AdmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRepository extends JpaRepository<AdmissionEntity, Integer> {

}
