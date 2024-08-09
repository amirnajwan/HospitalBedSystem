package com.Group4.HospitalBedSystem.dto.response.satisfication;

import com.Group4.HospitalBedSystem.entity.satification.CategoryEntity;
import com.Group4.HospitalBedSystem.entity.satification.MeasurementEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FeedbackResponse {

    private int id;
    private CategoryEntity category;
    private MeasurementEntity measurement;
    private int rating;
    private LocalDateTime timestamp;
}