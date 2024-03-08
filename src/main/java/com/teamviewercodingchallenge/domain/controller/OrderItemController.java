package com.teamviewercodingchallenge.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.teamviewercodingchallenge.domain.model.OrderItem;
import com.teamviewercodingchallenge.domain.repository.OrderItemRepository;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order-items") // Base path for all operations
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepo;

    // Get a list of all order items
    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepo.findAll();
    }

    // Get an order item by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
        Optional<OrderItem> orderItem = orderItemRepo.findById(id);
        return orderItem.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new order item
    @PostMapping
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        // Additional validation and checks can be performed here
        return orderItemRepo.save(orderItem);
    }

    // Update an existing order item
    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Long id, @RequestBody OrderItem updatedOrderItem) {
        return orderItemRepo.findById(id)
                .map(orderItem -> {
                    // Update orderItem fields here
                    // e.g., orderItem.setQuantity(updatedOrderItem.getQuantity());
                    OrderItem savedOrderItem = orderItemRepo.save(orderItem);
                    return ResponseEntity.ok(savedOrderItem);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete an order item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderItem(@PathVariable Long id) {
        return orderItemRepo.findById(id)
                .map(orderItem -> {
                    orderItemRepo.delete(orderItem);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
