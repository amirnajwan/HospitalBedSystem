package com.Group4.HospitalBedSystem.repository.satisfaction;

import com.Group4.HospitalBedSystem.entity.satification.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
