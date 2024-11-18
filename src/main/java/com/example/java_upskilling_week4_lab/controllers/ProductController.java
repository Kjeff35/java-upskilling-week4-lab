package com.example.java_upskilling_week4_lab.controllers;

import com.example.java_upskilling_week4_lab.models.Product;
import com.example.java_upskilling_week4_lab.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

/**
 * Controller responsible for managing product-related operations.
 * Provides endpoints for creating, retrieving, updating, and deleting products.
 */
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * Endpoint to add a new product.
     *
     * @param product The product details to be created.
     * @return ResponseEntity containing the created product and its URI.
     */
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product createdProduct = productService.addProduct(product);
        URI location = URI.create(String.format("/products/%d", createdProduct.getId()));
        return ResponseEntity.created(location).body(createdProduct);
    }

    /**
     * Endpoint to retrieve all products.
     *
     * @return ResponseEntity containing a list of all products.
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * Endpoint to retrieve a product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return ResponseEntity containing the product if found, or 404 status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    /**
     * Endpoint to update an existing product.
     *
     * @param id The ID of the product to update.
     * @param product The updated product details.
     * @return ResponseEntity containing the updated product if successful, or 404 status if not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return updatedProduct != null ? ResponseEntity.ok(updatedProduct) : ResponseEntity.notFound().build();
    }

    /**
     * Endpoint to delete a product by its ID.
     *
     * @param id The ID of the product to delete.
     * @return ResponseEntity indicating whether the product was successfully deleted (204 No Content) or not found (404 Not Found).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean isDeleted = productService.deleteProduct(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
