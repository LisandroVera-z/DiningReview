package com.LisandroVera.DiningReview.Repositories;

import com.LisandroVera.DiningReview.Entities.DiningReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiningReviewRepository extends JpaRepository<DiningReview, Integer> {

}

