package com.LisandroVera.DiningReview.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "RESTAURANTS")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String address;

    private Double peanutScore;
    private Double eggScore;
    private Double dairyScore;
    private Double overallScore;

    public Double calculateOverallScore() {
        int count = 0;
        double totalScore = 0.0;

        if (peanutScore != null) {
            totalScore += peanutScore;
            count++;
        }
        if (eggScore != null) {
            totalScore += eggScore;
            count++;
        }
        if (dairyScore != null) {
            totalScore += dairyScore;
            count++;
        }

        // Avoid division by zero
        return count > 0 ? totalScore / count : null;
    }
}


