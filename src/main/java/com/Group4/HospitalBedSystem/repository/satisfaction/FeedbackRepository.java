package com.Group4.HospitalBedSystem.repository.satisfaction;

import com.Group4.HospitalBedSystem.entity.satification.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.time.LocalDateTime;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

    List<Feedback> findByMeasurementCategoryId(int categoryId);

    List<Feedback> findByMeasurementId(int measurementId);

    List<Feedback> findByRating(int rating);

    @Query("SELECT AVG(f.rating) FROM Feedback f WHERE f.measurement.id = ?1")
    double findAverageRatingByMeasurementId(int measurementId);

    @Query("SELECT f FROM Feedback f WHERE f.timestamp >= :start AND f.timestamp <= :end")
    List<Feedback> findAllByTimestampBetween(LocalDateTime start, LocalDateTime end);

}