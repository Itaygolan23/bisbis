package com.att.tdp.bisbis10.Ratings;

import com.att.tdp.bisbis10.Resturant.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getRatingsByRestaurantId(Restaurant restaurantId) {
        return ratingRepository.findByRestaurantId(restaurantId);
    }

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }
}

