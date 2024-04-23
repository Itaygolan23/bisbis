package com.att.tdp.bisbis10.Ratings;

import com.att.tdp.bisbis10.Resturant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByRestaurantId(Restaurant restaurantId);
}

 

