package com.LisandroVera.DiningReview.Controllers;

import com.LisandroVera.DiningReview.Repositories.RestaurantRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Restaurants")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
    private RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

}
