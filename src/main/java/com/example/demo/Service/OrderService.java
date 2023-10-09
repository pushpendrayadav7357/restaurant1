package com.example.demo.Service;

import com.example.demo.Entity.Order;
import com.example.demo.Interfaces.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {

        return orderRepository.save(order);
    }

    public List<Order> getUserOrders(Long userId) {

        return orderRepository.findByUserId(userId);
    }

    public Optional<Order> getOrderById(Long orderId) {

        return orderRepository.findById(orderId);
    }

    public Order updateOrder(Long orderId, Order updatedOrder) {

        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));


        existingOrder.setQuantity(updatedOrder.getQuantity());
        existingOrder.setStatus(updatedOrder.getStatus());
        existingOrder.setFoodItemId(updatedOrder.getFoodItemId());

        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long orderId) {

        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        orderRepository.delete(existingOrder);
    }
}