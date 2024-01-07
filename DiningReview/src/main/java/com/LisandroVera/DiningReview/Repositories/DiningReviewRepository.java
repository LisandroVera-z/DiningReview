package com.LisandroVera.DiningReview.Repositories;

import com.LisandroVera.DiningReview.Controllers.AdminReviewAction;
import com.LisandroVera.DiningReview.Entities.DiningReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiningReviewRepository extends JpaRepository<DiningReview, Integer> {
        DiningReview findByAdminReviewAction(AdminReviewAction adminReviewAction);
        List<DiningReview> findByRestaurantIdAndAdminReviewAction(Integer id, AdminReviewAction adminReviewAction);

    }

