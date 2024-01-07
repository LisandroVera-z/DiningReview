package com.LisandroVera.DiningReview.Controllers;

import com.LisandroVera.DiningReview.Entities.Restaurant;
import com.LisandroVera.DiningReview.Repositories.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;

    private RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    //Find restaurant by its unique ID
    @GetMapping
    public Restaurant getById(@RequestParam Integer id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (!restaurantOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return restaurantOptional.get();
    }

    //Find restaurants by zip code and sorted by their score for a specific allergy, descending order
    @GetMapping("/{zipCode}")
    public List<Restaurant> getByZipCode(@PathVariable Integer zipCode, @RequestParam String allergy) {
        if (allergy.toLowerCase() == "peanut") {
            return restaurantRepository.findByZipCodeOrderByPeanutScoreDesc(zipCode);
        } else if (allergy.toLowerCase() == "egg") {
            return restaurantRepository.findByZipCodeOrderByEggScoreDesc(zipCode);
        } else if (allergy.toLowerCase() == "dairy") {
            return restaurantRepository.findByZipCodeOrderByDairyScoreDesc(zipCode);
        } else {
            return restaurantRepository.findByZipCode(zipCode);
        }
    }

    //Add restaurant
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurantToAdd) {
        if (restaurantRepository.existsByName(restaurantToAdd.getName()) && restaurantRepository.existsByZipCode(restaurantToAdd.getZipCode())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        restaurantRepository.save(restaurantToAdd);
        return restaurantToAdd;
    }
}