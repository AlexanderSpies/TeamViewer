/*
 * File: OrderController.java
 * Description: This file defines the RESTful API endpoints for managing orders.
 * Author: Alexander D. Spies
 * Date: 9 March 2024
 * 
 * This controller class provides endpoints for performing CRUD operations on orders.
 * It interacts with an OrderRepository to handle data persistence.
 * 
 * Endpoints:
 * - GET /api/orders: Retrieves a list of all orders.
 * - GET /api/orders/{id}: Retrieves an order by its ID.
 * - POST /api/orders: Creates a new order.
 * - PUT /api/orders/{id}: Updates an existing order.
 * - DELETE /api/orders/{id}: Deletes an order by its ID.
 * 
 * Dependencies:
 * - Spring framework: Used for dependency injection and RESTful web services.
 * - Order model: Represents the structure of an order.
 * - OrderRepository: Handles database operations for orders.
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
     public ResponseEntity<?> getAllOrders() {
         try {
             List<Order> orders = orderRepo.findAll();
             if (orders.isEmpty()) {
                 return ResponseEntity.noContent().build(); // No orders found
             }
             return ResponseEntity.ok(orders);
         } catch (Exception e) {
             return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
         }
     }
 
     // Get an order by ID
     @GetMapping("/{id}")
     public ResponseEntity<?> getOrderById(@PathVariable Long id) {
         try {
             Optional<Order> order = orderRepo.findById(id);
             return order.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build()); // Order not found
         } catch (Exception e) {
             return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
         }
     }
 
     // Create a new order
     @PostMapping
     public ResponseEntity<?> createOrder(@RequestBody Order order) {
         try {
             Order newOrder = orderRepo.save(order);
             return ResponseEntity.status(201).body(newOrder); // Order created successfully
         } catch (Exception e) {
             return ResponseEntity.status(400).body("Bad request: " + e.getMessage()); // Bad request
         }
     }
 
     // Update an existing order
     @PutMapping("/{id}")
     public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
         try {
             Optional<Order> existingOrder = orderRepo.findById(id);
             if (!existingOrder.isPresent()) {
                 return ResponseEntity.notFound().build(); // Order not found
             }
             Order order = existingOrder.get();
             // Update order fields here
             // e.g., order.setField(updatedOrder.getField());
             Order savedOrder = orderRepo.save(order);
             return ResponseEntity.ok(savedOrder); // Order updated successfully
         } catch (Exception e) {
             return ResponseEntity.status(500).body("Internal server error: " + e.getMessage()); // Internal server error
         }
     }
 
     // Delete an order by ID
     @DeleteMapping("/{id}")
     public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
         try {
             Optional<Order> existingOrder = orderRepo.findById(id);
             if (!existingOrder.isPresent()) {
                 return ResponseEntity.notFound().build(); // Order not found
             }
             orderRepo.deleteById(id);
             return ResponseEntity.noContent().build(); // Order deleted successfully
         } catch (Exception e) {
             return ResponseEntity.status(500).body("Internal server error: " + e.getMessage()); // Internal server error
         }
     }
 }
 