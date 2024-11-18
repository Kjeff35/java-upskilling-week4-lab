package com.example.java_upskilling_week4_lab.services;

import com.example.java_upskilling_week4_lab.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public Product addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProduct(Long id, Product product);

    boolean deleteProduct(Long id);
}
