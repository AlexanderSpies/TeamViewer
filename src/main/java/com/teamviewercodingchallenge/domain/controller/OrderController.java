package com.teamviewercodingchallenge.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.teamviewercodingchallenge.domain.model.Order;
import com.teamviewercodingchallenge.domain.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders") // Base path for all operations
public class OrderController {

    @Autowired
    private OrderRepository orderRepo;

    // Get a list of all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    // Get an order by ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderRepo.findById(id);
        return order.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepo.save(order);
    }

    // Update an existing order
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        return orderRepo.findById(id)
                .map(order -> {
                    // Update order fields here
                    // e.g., order.setField(updatedOrder.getField());
                    Order savedOrder = orderRepo.save(order);
                    return ResponseEntity.ok(savedOrder);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete an order by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        return orderRepo.findById(id)
                .map(order -> {
                    orderRepo.delete(order);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
