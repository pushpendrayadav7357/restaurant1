package com.example.demo.Interfaces;

import com.example.demo.Entity.FoodItem;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

}




