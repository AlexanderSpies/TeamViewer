/*
 * File: Order.java
 * Description: This file defines the entity class representing an order.
 * Author: Alexander D. Spies
 * Date: 9 March 2024
 * 
 * This entity class represents an order in the system. It is mapped to the "orders" table in the database.
 * 
 * Fields:
 * - id: Unique identifier for each Order instance. It is the primary key of the "orders" table.
 * - orderDate: Date when the order was placed.
 * - status: Status of the order (e.g., "shipped", "processing").
 * 
 * Dependencies:
 * - Jakarta Persistence API (JPA): Annotations for defining entity classes and mapping them to database tables.
 * 
 * Usage:
 * - This class is used to create, retrieve, update, and delete orders in the database.
 * - Customize the fields and annotations according to the specific requirements of your application.
 * 
 * For more information about Jakarta Persistence API (JPA), refer to the official documentation:
 * - Jakarta Persistence: https://jakarta.ee/specifications/persistence/3.0/
 */

// Define the package name. This is used to organize the class into a namespace.
package com.teamviewercodingchallenge.domain.model;

// Import statements for various annotations and classes used in this entity class.
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

// Annotation to declare this class as an Entity, mapping it to a database table.
@Entity
// Annotation to specify the table in the database to which this entity maps.
@Table(name = "orders")
public class Order {
    
    // Field `id` is annotated with @Id to denote it as the primary key of the entity.
    @Id
    // The @GeneratedValue annotation specifies that the database will automatically generate the value for this field.
    // The strategy 'IDENTITY' indicates that the database identity column is used for auto-incrementation.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for each Order instance.
    
    private Date orderDate; // Field to store the date when the order was placed.
    private String status; // Field to store the status of the order (e.g., "shipped", "processing").
}
