package teamviewer.controller;

import <your-package-name>.model.Product;
import <your-package-name>.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Marks this class as a Spring MVC controller handling REST requests
@RestController
public class ProductController {

    // Automatically injects an instance of productRepo
    @Autowired
    private productRepo productRepo;

    // Maps GET requests to /products to this method
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        // Fetches all products from the database using the productRepo
        return productRepo.findAll();
    }
}
