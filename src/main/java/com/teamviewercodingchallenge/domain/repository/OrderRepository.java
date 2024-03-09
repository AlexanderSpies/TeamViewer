/*
 * File: OrderRepository.java
 * Description: This file defines the repository interface for managing Order entities.
 * Author: Alexander D Spies
 * Date: 9 March 2024
 * 
 * This repository interface extends JpaRepository, providing CRUD (Create, Read, Update, Delete) operations
 * for Order entities in the database.
 * 
 * Dependencies:
 * - Spring Data JPA: Provides JpaRepository interface for working with JPA entities.
 * 
 * Usage:
 * - This interface is used to define methods for accessing and manipulating Order entities in the database.
 * - Extending JpaRepository allows this repository to inherit methods for CRUD operations without needing to implement them.
 * - Customize the repository interface according to the specific data access requirements of your application.
 * 
 * For more information about Spring Data JPA, refer to the official documentation:
 * - Spring Data JPA: https://spring.io/projects/spring-data-jpa
 */

// Defines the package name, grouping this interface within a specific part of the application's structure. This helps in organizing the codebase, especially in large projects.
package com.teamviewercodingchallenge.domain.repository;

// Import statements for classes and interfaces this repository depends on. These enable the use of JPA (Java Persistence API) functionalities and integration with Spring Data JPA.
import com.teamviewercodingchallenge.domain.model.Order;

import org.springframework.data.jpa.repository.JpaRepository; // Imports the JpaRepository interface from Spring Data JPA, providing CRUD operations for entities.

// Declares the OrderRepository interface extending JpaRepository. This enables it to inherit methods for working with Order data in the database.
public interface OrderRepository extends JpaRepository<Order, Long> {
    // By extending JpaRepository, OrderRepository inherits methods to save, delete, and find Order entities, among others.
    // The first type parameter, Order, specifies the entity type the repository manages.
    // The second type parameter, Long, specifies the type of the entity's primary key.
}
