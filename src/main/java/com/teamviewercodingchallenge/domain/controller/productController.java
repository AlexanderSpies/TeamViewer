/*
 * File: ProductController.java
 * Description: This file defines the RESTful API endpoints for managing products.
 * Author: Alexander D Spies
 * Date: 9 March 2024
 * 
 * This controller class provides endpoints for performing CRUD operations on products.
 * It interacts with a ProductRepository to handle data persistence.
 * 
 * Endpoints:
 * - GET /api/products: Retrieves a list of all products.
 * - GET /api/products/{id}: Retrieves a product by its ID.
 * - POST /api/products: Creates a new product.
 * - PUT /api/products/{id}: Updates an existing product.
 * - DELETE /api/products/{id}: Deletes a product by its ID.
 * 
 * Dependencies:
 * - Spring framework: Used for dependency injection and RESTful web services.
 * - Product model: Represents the structure of a product.
 * - ProductRepository: Handles database operations for products.
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
 import org.springframework.http.HttpStatus;
 import com.teamviewercodingchallenge.domain.model.Product;
 import com.teamviewercodingchallenge.domain.repository.ProductRepository;
 
 import java.util.List;
 import java.util.Optional;
 
 @RestController
 @RequestMapping("/api/products")
 public class ProductController {
 
     @Autowired
     private ProductRepository productRepo;
 
     // Get a list of all products
     @GetMapping
     public ResponseEntity<List<Product>> getAllProducts() {
         try {
             List<Product> products = productRepo.findAll();
             return new ResponseEntity<>(products, HttpStatus.OK);
         } catch (Exception e) {
             return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
         }
     }
 
     // Get a product by ID
     @GetMapping("/{id}")
     public ResponseEntity<Product> getProductById(@PathVariable Long id) {
         try {
             Optional<Product> product = productRepo.findById(id);
             return product.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.notFound().build());
         } catch (Exception e) {
             return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
         }
     }
 
     // Create a new product
     @PostMapping
     public ResponseEntity<Product> createProduct(@RequestBody Product product) {
         try {
             Product savedProduct = productRepo.save(product);
             return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
         } catch (Exception e) {
             return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
         }
     }
 
     // Update an existing product by product ID
     @PutMapping("/{id}")
     public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
         try {
             return productRepo.findById(id)
                     .map(product -> {
                         product.setName(updatedProduct.getName());
                         product.setPrice(updatedProduct.getPrice());
                         Product savedProduct = productRepo.save(product);
                         return ResponseEntity.ok(savedProduct);
                     })
                     .orElseGet(() -> ResponseEntity.notFound().build());
         } catch (Exception e) {
             return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
         }
     }
 
     // Delete a product by ID
     @DeleteMapping("/{id}")
     public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
         try {
             return productRepo.findById(id)
                     .map(product -> {
                         productRepo.delete(product);
                         return ResponseEntity.ok().build();
                     })
                     .orElseGet(() -> ResponseEntity.notFound().build());
         } catch (Exception e) {
             return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
         }
     }
 }
 