package com.Group4.HospitalBedSystem.dto.response.satisfication;

import java.util.List;
import lombok.Data;

@Data
public class CategoryResponse {
    private int id;
    private String name;
    private List<MeasurementResponse> measurements;
}
