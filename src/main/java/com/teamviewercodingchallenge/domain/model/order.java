// Define the package name. This is used to organize the class into a namespace.
package com.teamviewercodingchallenge.domain.model;

// Import statements for various annotations and classes used in this entity class.
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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