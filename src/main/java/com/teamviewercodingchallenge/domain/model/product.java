// Defines the package name, which organizes the class into a specific group or namespace within the application. This is useful for managing code in a large project.
package com.teamviewer.domain;

// Import statements for annotations and classes used in this entity class from the Java Persistence API (JPA). These enable the mapping of this class to a database table.
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
