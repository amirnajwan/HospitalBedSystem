package com.Group4.HospitalBedSystem.dto.response.satisfication;

import java.util.List;

import com.Group4.HospitalBedSystem.entity.satification.FeedbackEntity;
import lombok.Data;

@Data
public class CategoryResponse {
    private int id;
    private String name;
    private List<MeasurementResponse> measurements;
    private List<FeedbackEntity> feedbacks;
}
