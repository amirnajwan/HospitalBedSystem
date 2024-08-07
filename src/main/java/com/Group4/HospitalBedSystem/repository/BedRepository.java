package com.Group4.HospitalBedSystem.repository;

import com.Group4.HospitalBedSystem.entity.BedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedRepository extends JpaRepository<BedEntity, Integer> {
    BedEntity findBedByName(String name);
    BedEntity findBedByBedTypeId(String bedTypeId);
}
