package com.LisandroVera.DiningReview.Controllers;

import com.LisandroVera.DiningReview.Repositories.DiningReviewRepository;
import com.LisandroVera.DiningReview.Repositories.RestaurantRepository;
import com.LisandroVera.DiningReview.Repositories.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DiningReviews")
public class DiningReviewController {
    private final DiningReviewRepository diningReviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    public DiningReviewController(DiningReviewRepository diningReviewRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.diningReviewRepository = diningReviewRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }
}
