package com.example.java_upskilling_week4_lab.services.impl;

import com.example.java_upskilling_week4_lab.handlers.NotFoundException;
import com.example.java_upskilling_week4_lab.models.Product;
import com.example.java_upskilling_week4_lab.repositories.ProductRepository;
import com.example.java_upskilling_week4_lab.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product product) {
        Product oldProduct = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with ID " + id + " not found"));
        oldProduct.setName(product.getName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setPrice(product.getPrice());

        return productRepository.save(oldProduct);
    }

    public boolean deleteProduct(Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with ID " + id + " not found"));

        productRepository.deleteById(id);
        return true;
    }
}
