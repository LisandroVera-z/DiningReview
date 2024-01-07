package com.LisandroVera.DiningReview.Entities;

import com.LisandroVera.DiningReview.Controllers.AdminReviewAction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "DINING_REVIEWS")
public class DiningReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String displayName;

    @ManyToOne
    private Restaurant restaurant;

    private Double peanutScore;
    private Double eggScore;
    private Double dairyScore;
    private String commentary;

    private AdminReviewAction adminReviewAction;

}

