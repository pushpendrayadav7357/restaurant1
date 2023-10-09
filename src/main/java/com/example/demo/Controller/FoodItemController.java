package com.example.demo.Controller;

import com.example.demo.Entity.FoodItem;
import com.example.demo.Service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-items")
public class FoodItemController {
    @Autowired
    private FoodItemService foodItemService;

    @PostMapping("/create")
    public ResponseEntity<FoodItem> createFoodItem(@RequestBody FoodItem foodItem) {
        try {
            FoodItem createdFoodItem = foodItemService.createFoodItem(foodItem);
            return new ResponseEntity<>(createdFoodItem, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/all")
    public ResponseEntity<List<FoodItem>> getAllFoodItems() {

        List<FoodItem> foodItems = foodItemService.getAllFoodItems();
        return new ResponseEntity<>(foodItems, HttpStatus.OK);
    }

    @GetMapping("/{foodItemId}")
    public ResponseEntity<FoodItem> getFoodItemById(@PathVariable Long foodItemId) {

        return foodItemService.getFoodItemById(foodItemId)
                .map(foodItem -> new ResponseEntity<>(foodItem, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }


    @PutMapping("/{foodItemId}")
    public ResponseEntity<FoodItem> updateFoodItem(@PathVariable Long foodItemId, @RequestBody FoodItem updatedFoodItem) {
        try {
            FoodItem updated = foodItemService.updateFoodItem(foodItemId, updatedFoodItem);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (IllegalArgumentException e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/{foodItemId}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable Long foodItemId) {
        try {
            foodItemService.deleteFoodItem(foodItemId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
