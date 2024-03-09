/*
 * File: OrderItemController.java
 * Description: This file defines the RESTful API endpoints for managing order items.
 * Author: Alexander D. Spies
 * Date: 9 March 2024
 * 
 * This controller class provides endpoints for performing CRUD operations on order items.
 * It interacts with an OrderItemRepository to handle data persistence.
 * 
 * Endpoints:
 * - GET /api/order-items: Retrieves a list of all order items.
 * - GET /api/order-items/{id}: Retrieves an order item by its ID.
 * - POST /api/order-items: Creates a new order item.
 * - PUT /api/order-items/{id}: Updates an existing order item.
 * - DELETE /api/order-items/{id}: Deletes an order item by its ID.
 * 
 * Dependencies:
 * - Spring framework: Used for dependency injection and RESTful web services.
 * - OrderItem model: Represents the structure of an order item.
 * - OrderItemRepository: Handles database operations for order items.
 * 
 * Usage:
 * - To use this controller, ensure that Spring Boot and necessary dependencies are configured.
 * - The controller can be tested using tools like Postman or by writing unit tests.
 * - Customize the update and delete methods to suit the specific requirements of your application.
 * 
 * For more information about Spring Boot and RESTful web services, refer to the official documentation:
 * - Spring Boot: https://spring.io/projects/spring-boot
 * - RESTful web services with Spring: https://spring.io/guides/gs/rest-service/
 */


package com.teamviewercodingchallenge.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.teamviewercodingchallenge.domain.model.OrderItem;
import com.teamviewercodingchallenge.domain.repository.OrderItemRepository;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

//prior to touching any API endpoints which communicat with the Postgresql for CRUD operations and ordering items I would ensure authentication for anyone trying to log in and touch the database see sudo code below, Loginuth is place before any other code to enure all personnel touching the DB are authorized. 

    //public class LoginAuth {
    // public static void main(String[] args) {
    //     // Instantiate the authentication manager
    //     AuthenticationManager authManager = new AuthenticationManager();

    //     // Simulated login attempt
    //     String username = "user1";
    //     String password = "password1";

    //     // Authenticate user credentials
    //     if (authManager.authenticate(username, password)) {
    //         System.out.println("Authentication successful. Welcome, " + username + "!");
    //         // Proceed with application logic for authenticated users
    //     } else {
    //         System.out.println("Authentication failed. Invalid username or password.");
    //         return ResponseEntity.status(401).body("Unauthorized" + e.getMessage());
    //         // Handle unsuccessful authentication (e.g., display error message, redirect to login page)
    //     }
    // }
    @Autowired
    private OrderItemRepository orderItemRepo;

    // Get a list of all order items
    @GetMapping
    public ResponseEntity<?> getAllOrderItems() {
        try {
            List<OrderItem> orderItems = orderItemRepo.findAll();
            if (orderItems.isEmpty()) {
                return ResponseEntity.noContent().build(); // No order items found
            }
            return ResponseEntity.ok(orderItems);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
        }
    }

    // Get an order item by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderItemById(@PathVariable Long id) {
        try {
            Optional<OrderItem> orderItem = orderItemRepo.findById(id);
            return orderItem.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build()); // Order item not found
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
        }
    }

    // Create a new order item
    @PostMapping
    public ResponseEntity<?> createOrderItem(@RequestBody OrderItem orderItem) {
        try {
            // Additional validation and checks can be performed here
            OrderItem savedOrderItem = orderItemRepo.save(orderItem);
            return ResponseEntity.status(201).body(savedOrderItem); // Order item created successfully
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Bad request: " + e.getMessage()); // Bad request
        }
    }

    // Update an existing order item
    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderItem(@PathVariable Long id, @RequestBody OrderItem updatedOrderItem) {
        try {
            return orderItemRepo.findById(id)
                    .map(orderItem -> {
                        // Update orderItem fields here
                        // e.g., orderItem.setQuantity(updatedOrderItem.getQuantity());
                        OrderItem savedOrderItem = orderItemRepo.save(orderItem);
                        return ResponseEntity.ok(savedOrderItem); // Order item updated successfully
                    })
                    .orElseGet(() -> ResponseEntity.notFound().build()); // Order item not found
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error: " + e.getMessage()); // Internal server error
        }
    }

    // Delete an order item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderItem(@PathVariable Long id) {
        try {
            return orderItemRepo.findById(id)
                    .map(orderItem -> {
                        orderItemRepo.delete(orderItem);
                        return ResponseEntity.noContent().build(); // Order item deleted successfully
                    })
                    .orElseGet(() -> ResponseEntity.notFound().build()); // Order item not found
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error: " + e.getMessage()); // Internal server error
        }
    }
}
