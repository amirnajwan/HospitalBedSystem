package com.Group4.HospitalBedSystem.entity.satification;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "feedbacks")
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "measurement_id", nullable = false)
    private MeasurementEntity measurement;

    private int rating;

    @NonNull
    private LocalDateTime timestamp;

    // Additional fields if needed
}
