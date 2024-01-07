package com.LisandroVera.DiningReview.Controllers;

import com.LisandroVera.DiningReview.Entities.AdminReviewAction;
import com.LisandroVera.DiningReview.Entities.DiningReview;
import com.LisandroVera.DiningReview.Entities.Restaurant;
import com.LisandroVera.DiningReview.Repositories.DiningReviewRepository;
import com.LisandroVera.DiningReview.Repositories.RestaurantRepository;
import com.LisandroVera.DiningReview.Repositories.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public List<DiningReview> getAllDiningReviews() {
        return diningReviewRepository.findAll();
    }
    @GetMapping("/{id}")
    public List<DiningReview> getByRestaurant(@PathVariable Integer id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if(!optionalRestaurant.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return diningReviewRepository.findByRestaurantIdAndAdminReviewAction(id, AdminReviewAction.ACCEPT);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/PostReview")
    public DiningReview postReview(@RequestBody @NotNull DiningReview review) {
        if(!userRepository.existsByDisplayName(review.getDisplayName())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        review.setAdminReviewAction(AdminReviewAction.PENDING);
        diningReviewRepository.save(review);
        return review;
    }

    //Admin endpoint to get pending reviews
    @GetMapping("/admin")
    public List<DiningReview> getPendingReviews() {
        return diningReviewRepository.findByAdminReviewAction(AdminReviewAction.PENDING);
    }

    //Admin endpoint to change a review's status either to ACCEPTED or REJECTED
    @PutMapping("/admin/{id}")
    public DiningReview setReviewStatus(@PathVariable Integer id, @RequestParam Boolean accepted) {
        Optional<DiningReview> optionalReview = diningReviewRepository.findById(id);
        if (!optionalReview.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        DiningReview review = optionalReview.get();
        if (accepted) {
            review.setAdminReviewAction(AdminReviewAction.ACCEPT);
        } else {
            review.setAdminReviewAction(AdminReviewAction.REJECT);
        }
        diningReviewRepository.save(review);
        return review;

    }
}