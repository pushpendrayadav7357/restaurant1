package com.example.demo.Service;

import com.example.demo.Entity.FoodItem;
import com.example.demo.Interfaces.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {
    @Autowired
    private FoodItemRepository foodItemRepository;

    public FoodItem createFoodItem(FoodItem foodItem) {

        return foodItemRepository.save(foodItem);
    }

    public List<FoodItem> getAllFoodItems() {

        return foodItemRepository.findAll();
    }

    public Optional<FoodItem> getFoodItemById(Long foodItemId) {

        return foodItemRepository.findById(foodItemId);
    }

    public FoodItem updateFoodItem(Long foodItemId, FoodItem updatedFoodItem) {

        FoodItem existingFoodItem = foodItemRepository.findById(foodItemId)
                .orElseThrow(() -> new IllegalArgumentException("Food item not found"));


        existingFoodItem.setTitle(updatedFoodItem.getTitle());
        existingFoodItem.setDescription(updatedFoodItem.getDescription());
        existingFoodItem.setPrice(updatedFoodItem.getPrice());

        return foodItemRepository.save(existingFoodItem);
    }

    public void deleteFoodItem(Long foodItemId) {

        FoodItem existingFoodItem = foodItemRepository.findById(foodItemId)
                .orElseThrow(() -> new IllegalArgumentException("Food item not found"));

        foodItemRepository.delete(existingFoodItem);
    }
}