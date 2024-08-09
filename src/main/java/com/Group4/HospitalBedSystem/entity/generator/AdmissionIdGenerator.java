package com.Group4.HospitalBedSystem.entity.generator;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdmissionIdGenerator {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public String generateNewAdmissionId(){
        String prefix = "ADM";
        String query = "SELECT COUNT(e) FROM AdmissionEntity e";
        Long count = (Long) entityManager.createQuery(query).getSingleResult();
        long nextId = count + 1;
        return String.format("%s%04d", prefix, nextId);
    }
}
