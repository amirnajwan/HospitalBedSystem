package com.Group4.HospitalBedSystem.dto.response.satisfication;

import java.util.List;
import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;
    private String name;
    private List<MeasurementDTO> measurements;

}
