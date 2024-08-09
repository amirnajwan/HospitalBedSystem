package com.Group4.HospitalBedSystem.dto.response.satisfication;

import com.Group4.HospitalBedSystem.entity.satification.FeedbackEntity;
import lombok.Data;

import java.util.List;

@Data
public class MeasurementResponse {
    private int id;
    private String name;
    private int categoryId;
    private List<FeedbackEntity> feedbacks;

}
