package com.att.tdp.bisbis10.Ratings;

import com.att.tdp.bisbis10.Resturant.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating) {
        Rating addedRating = ratingService.addRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedRating);
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<List<Rating>> getRatingsByRestaurantId(@PathVariable Restaurant restaurantId) {
        List<Rating> ratings = ratingService.getRatingsByRestaurantId(restaurantId);
        return ResponseEntity.ok(ratings);
    }
}
