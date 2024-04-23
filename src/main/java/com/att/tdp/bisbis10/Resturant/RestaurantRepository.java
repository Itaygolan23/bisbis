package com.att.tdp.bisbis10.Resturant;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByCuisinesContaining(String cuisine);
    Optional<Restaurant> findById(Restaurant restaurant2);
}
