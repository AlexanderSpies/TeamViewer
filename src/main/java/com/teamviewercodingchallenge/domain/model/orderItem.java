// Defines the package name to organize the class within a namespace. This helps in maintaining a structured and organized codebase.
package com.teamviewercodingchallenge.domain.model;

// Import statements for annotations and classes used in this entity class. These are part of the Java Persistence API (JPA), which is used for ORM (Object-Relational Mapping).
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


// The @Entity annotation marks this class as a JPA entity, indicating it should be mapped to a database table.
@Entity
// The @Table annotation specifies the name of the table in the database that this entity maps to. In this case, 'orderedItems'.
@Table(name = "orderedItems")
public class OrderItem {
    
    // The @Id annotation denotes this field as the primary key of the entity.
    @Id
    // @GeneratedValue specifies that the database should automatically generate the value for this field, using an identity column for auto-increment.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for each OrderItem instance.

    // The @ManyToOne annotation indicates a many-to-one relationship between order items and an order.
    // Each order item belongs to one order, but an order can have many order items.
    @ManyToOne
    private Order order; // Reference to the Order entity that this OrderItem is part of.
    
    // The @ManyToOne annotation here indicates a many-to-one relationship between order items and products.
    // Each order item is associated with one product, but a product can be part of many order items.
    @ManyToOne
    private Product product; // Reference to the Product entity that this OrderItem is associated with.
    
    private int quantity; // Field to store the quantity of the product in this order item.
}
