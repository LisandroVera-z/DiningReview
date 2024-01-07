package com.LisandroVera.DiningReview.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String displayName;
    private String city;
    private String state;
    private String zipcode;
    private boolean interestedInPeanutAllergies;
    private boolean interestedInEggAllergies;
    private boolean interestedInDairyAllergies;

}

