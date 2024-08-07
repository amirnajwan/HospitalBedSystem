package com.Group4.HospitalBedSystem.service.satisfaction;

import com.Group4.HospitalBedSystem.entity.satification.*;
import com.Group4.HospitalBedSystem.repository.satisfaction.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Feedback saveFeedback(Feedback feedback) {
        //feedback.setTimestamp(LocalDateTime.now());
        return feedbackRepository.save(feedback);
    }

    public List<Feedback> getFeedbackByCategory(int categoryId) {
        return feedbackRepository.findByMeasurementCategoryId(categoryId);
    }

    public List<Feedback> getFeedbackByMeasurementId(int measurementId) {
        return feedbackRepository.findByMeasurementId(measurementId);
    }

    public List<Feedback> getFeedbackByRating(int rating) {
        return feedbackRepository.findByRating(rating);
    }
//satu
//    public double calculateAverageRating(List<Feedback> feedbacks) {
//        int totalRating = (int) feedbacks.stream().mapToInt(Feedback::getRating).sum();
//        return (double) totalRating / feedbacks.size();
//    }

    //dua
    public double getAverageRating(int measurementId) {
        return feedbackRepository.findAverageRatingByMeasurementId(measurementId);
    }

}