package com.Group4.HospitalBedSystem.entity.satification;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "measurements")
public class MeasurementEntity {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Getter
    @NonNull
    private String name;
    //private int rating; // values 1 to 5

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;


//    @OneToMany(mappedBy = "measurement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Feedback> feedbacks;

}