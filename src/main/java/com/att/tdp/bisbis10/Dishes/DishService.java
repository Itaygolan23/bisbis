package com.att.tdp.bisbis10.Dishes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.Resturant.Restaurant;
import com.att.tdp.bisbis10.Resturant.RestaurantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    private static DishRepository dishRepository = null;
    private static RestaurantRepository restaurantRepository = null;

    @Autowired
    public DishService(DishRepository dishRepository, RestaurantRepository restaurantRepository) {
        DishService.dishRepository = dishRepository;
        DishService.restaurantRepository = restaurantRepository;
    }

    // Add a dish for a specific restaurant
    public static Dishes addDish(Long restaurantId, Dishes dish) throws Exception {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if (restaurantOptional.isEmpty()) {
            throw new Exception("Restaurant with ID " + restaurantId + " not found");
        }

        Restaurant restaurant = restaurantOptional.get();
        dish.setRestaurant(restaurant);
        return dishRepository.save(dish);
    }

    // Update a dish
    public static Dishes updateDish(Long restaurantId, Long dishId, Dishes dishDetails) throws Exception {
        Optional<Dishes> dishOptional = dishRepository.findByIdAndRestaurantId(dishId, restaurantId);
        if (dishOptional.isEmpty()) {
            throw new Exception("Dish with ID " + dishId + " not found for Restaurant with ID " + restaurantId);
        }

        Dishes dish = dishOptional.get();
        dish.setDescription(dishDetails.getDescription());
        dish.setPrice(dishDetails.getPrice());
        // Update other properties as needed

        return dishRepository.save(dish);
    }

    // Delete a dish
    public static void deleteDish(Long restaurantId, Long dishId) throws Exception {
        Optional<Dishes> dishOptional = dishRepository.findByIdAndRestaurantId(dishId, restaurantId);
        if (dishOptional.isEmpty()) {
            throw new Exception("Dish with ID " + dishId + " not found for Restaurant with ID " + restaurantId);
        }

        dishRepository.deleteById(dishId);
    }

    // Get all dishes for a specific restaurant
    public static List<Dishes> getAllDishesByRestaurantId(Long restaurantId) {
        return dishRepository.findByRestaurantId(restaurantId);
    }
}
