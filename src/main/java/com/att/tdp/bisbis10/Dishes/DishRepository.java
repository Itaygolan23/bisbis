package com.att.tdp.bisbis10.Dishes;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface DishRepository extends JpaRepository<Dishes, Long> {
    List<Dishes> findByRestaurantId(Long restaurantId);
    Optional<Dishes> findByIdAndRestaurantId(Long id, Long restaurantId);
}

