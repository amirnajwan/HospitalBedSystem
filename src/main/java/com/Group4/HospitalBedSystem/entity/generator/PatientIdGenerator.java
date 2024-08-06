package com.Group4.HospitalBedSystem.entity.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Component
public class PatientIdGenerator {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public String generateNewPatientId(){
        String prefix = "PAT";
        String query = "SELECT COUNT(e) FROM PatientEntity e";
        Long count = (Long) entityManager.createQuery(query).getSingleResult();
        long nextId = count + 1;
        return String.format("%s%04d", prefix, nextId);
    }
}
