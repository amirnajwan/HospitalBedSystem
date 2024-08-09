package com.Group4.HospitalBedSystem.service.satisfaction;

import com.Group4.HospitalBedSystem.entity.satification.*;
import com.Group4.HospitalBedSystem.repository.satisfaction.*;
import com.Group4.HospitalBedSystem.service.general.SuccessAndDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MeasurementRepository measurementRepository;

    public ResponseEntity<?> submitFeedback(FeedbackEntity feedbackEntity) {
        SuccessAndDataResponse result = new SuccessAndDataResponse();
        try {
            if (feedbackEntity != null) {
                // Assuming you're passing the categoryId and measurementId in the FeedbackEntity
                Integer categoryId = feedbackEntity.getCategory() != null ? feedbackEntity.getCategory().getId() : null;
                Integer measurementId = feedbackEntity.getMeasurement() != null ? feedbackEntity.getMeasurement().getId() : null;

                if (categoryId != null && measurementId != null) {
                    // Fetch the associated CategoryEntity and MeasurementEntity
                    CategoryEntity category = categoryRepository.findById(categoryId)
                            .orElseThrow(() -> new Exception("Category not found"));
                    MeasurementEntity measurement = measurementRepository.findById(measurementId)
                            .orElseThrow(() -> new Exception("Measurement not found"));

                    // Set these entities into the feedbackEntity
                    feedbackEntity.setCategory(category);
                    feedbackEntity.setMeasurement(measurement);
                    feedbackEntity.setTimestamp(LocalDateTime.now()); // Set the timestamp

                    // Save the feedback
                    FeedbackEntity savedFeedback = feedbackRepository.save(feedbackEntity);
                    result.setSuccess(true);
                    result.setMessage("Added new feedback");
                    result.setData(savedFeedback);

                    return ResponseEntity.ok(result);
                } else {
                    result.setMessage("Category or Measurement ID is missing");
                    return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
                }
            } else {
                result.setMessage("FeedbackEntity is null");
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            result.setMessage("Failed to add feedback: " + e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    public long getTotalFeedbackCount(int categoryId, int measurementId) {
        return feedbackRepository.countByCategoryIdAndMeasurementId(categoryId, measurementId);
    }

}