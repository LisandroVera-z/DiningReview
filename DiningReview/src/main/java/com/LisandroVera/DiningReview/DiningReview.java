package com.LisandroVera.DiningReview;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DiningReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String submitterDisplayName;

    @ManyToOne
    private Restaurant restaurant;

    private Integer peanutScore;
    private Integer eggScore;
    private Integer dairyScore;
    private String commentary;
}

