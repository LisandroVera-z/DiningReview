package com.LisandroVera.DiningReview.Repositories;

import com.LisandroVera.DiningReview.Entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    List<Restaurant> findByZipCodeOrderByPeanutScoreDesc(Integer zipCode);
    List<Restaurant> findByZipCodeOrderByEggScoreDesc(Integer zipCode);
    List<Restaurant> findByZipCodeOrderByDairyScoreDesc(Integer zipCode);
    List<Restaurant> findByZipCode(Integer zipCode);
    Boolean existsByName(String name);
    Boolean existsByZipCode(Integer zipCode);


}
