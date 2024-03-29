/*
 * File: Product.java
 * Description: This file defines the entity class representing a product.
 * Author: Alexander D. Spies
 * Date: 9 March 2024
 * 
 * This entity class represents a product in the system. It is mapped to the "products" table in the database.
 * 
 * Fields:
 * - id: Unique identifier for each Product instance. It is the primary key of the "products" table.
 * - name: Name of the product.
 * - price: Price of the product.
 * - description: Description of the product.
 * 
 * Dependencies:
 * - Jakarta Persistence API (JPA): Annotations for defining entity classes and mapping them to database tables.
 * 
 * Usage:
 * - This class is used to represent products and their attributes.
 * - Customize the fields and annotations according to the specific requirements of your application.
 * 
 * For more information about Jakarta Persistence API (JPA), refer to the official documentation:
 * - Jakarta Persistence: https://jakarta.ee/specifications/persistence/3.0/
 */

// Defines the package name, which organizes the class into a specific group or namespace within the application. This is useful for managing code in a large project.
package com.teamviewercodingchallenge.domain.model;

// Import statements for annotations and classes used in this entity class from the Java Persistence API (JPA). These enable the mapping of this class to a database table.
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// The @Entity annotation marks this class as a JPA entity, indicating that it should be mapped to a database table.
@Entity
// The @Table annotation specifies the name of the database table to which this entity maps. In this case, the table is named 'products'.
@Table(name = "products")
public class Product {
    
    // The @Id annotation marks this field as the primary key of the entity.
    @Id
    // The @GeneratedValue annotation specifies that the value of the id field should be generated automatically by the database, using an identity column for auto-increment.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for each Product instance.
    
    private String name; // Field to store the name of the product.
    private double price; // Field to store the price of the product.
    private String description; // Field to store a description of the product.

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
