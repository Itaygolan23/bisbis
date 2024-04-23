package com.att.tdp.bisbis10.Dishes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants/{restaurantId}/dishes")
public class DishController {

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping
    public ResponseEntity<Dishes> addDishToRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody Dishes dish) throws Exception {
        Dishes savedDish = DishService.addDish(restaurantId, dish);
        return new ResponseEntity<>(savedDish, HttpStatus.CREATED);
    }

    @PutMapping("/{dishId}")
    public ResponseEntity<Dishes> updateDish(
            @PathVariable Long restaurantId,
            @PathVariable Long dishId,
            @RequestBody Dishes updatedDish) throws Exception {
        Dishes updated = DishService.updateDish(restaurantId, dishId, updatedDish);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{dishId}")
    public ResponseEntity<Void> deleteDish(
            @PathVariable Long restaurantId,
            @PathVariable Long dishId) throws Exception {
        DishService.deleteDish(restaurantId, dishId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Dishes>> getDishesByRestaurant(
            @PathVariable Long restaurantId) {
        List<Dishes> dishes = DishService.getAllDishesByRestaurantId(restaurantId);
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }

}

