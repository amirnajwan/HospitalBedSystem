package com.Group4.HospitalBedSystem.entity.satification;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "feedback")
public class Feedback {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    private int rating; // values 1 to 5

    @Setter
    @Getter
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "measurement_id")
    private MeasurementEntity measurement;

    @NonNull
    private String category;

    //validation for rating taking value from 1 -5 only
    public void setRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.rating = rating;
    }
}
