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


    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;



    //    @OneToMany(mappedBy = "measurement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Feedback> feedbacks;

}