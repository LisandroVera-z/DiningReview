package com.LisandroVera.DiningReview.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


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
    private Integer zipCode;
    private boolean peanutAllergies;
    private boolean eggAllergies;
    private boolean dairyAllergies;

}

