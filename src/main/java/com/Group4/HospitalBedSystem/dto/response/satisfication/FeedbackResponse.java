package com.Group4.HospitalBedSystem.dto.response.satisfication;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FeedbackResponse {

    private int id;
    private int rating;
    private LocalDateTime timestamp;
    private int measurementId;

}