package com.LisandroVera.DiningReview.Repositories;

import com.LisandroVera.DiningReview.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
