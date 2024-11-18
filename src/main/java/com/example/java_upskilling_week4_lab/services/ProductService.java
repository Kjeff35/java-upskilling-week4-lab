package com.example.java_upskilling_week4_lab.services;

import com.example.java_upskilling_week4_lab.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    /**
     * Adds a new product.
     *
     * @param product The product to be added.
     * @return The added product.
     */
    Product addProduct(Product product);

    /**
     * Retrieves all products.
     *
     * @return A list of all products.
     */
    List<Product> getAllProducts();

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The product with the given ID, or null if not found.
     */
    Product getProductById(Long id);

    /**
     * Updates an existing product.
     *
     * @param id      The ID of the product to update.
     * @param product The product details to update.
     * @return The updated product, or null if the product with the given ID does not exist.
     */
    Product updateProduct(Long id, Product product);

    /**
     * Deletes a product by its ID.
     *
     * @param id The ID of the product to delete.
     * @return true if the product was deleted successfully, false otherwise.
     */
    boolean deleteProduct(Long id);
}
