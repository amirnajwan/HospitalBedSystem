package com.Group4.HospitalBedSystem.entity.satification;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "measurements")
public class Measurement {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @NonNull
    private String name;
    //private int rating; // values 1 to 5

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "measurement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Feedback> feedbacks;

}