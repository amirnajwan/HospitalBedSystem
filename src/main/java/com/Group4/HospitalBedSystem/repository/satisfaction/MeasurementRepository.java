package com.Group4.HospitalBedSystem.repository.satisfaction;

import com.Group4.HospitalBedSystem.entity.satification.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MeasurementRepository extends JpaRepository<MeasurementEntity, Integer> {
    List<MeasurementEntity> findByCategoryId(int categoryId);
}
