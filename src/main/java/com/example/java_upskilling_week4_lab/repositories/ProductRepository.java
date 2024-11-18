package com.example.java_upskilling_week4_lab.repositories;

import com.example.java_upskilling_week4_lab.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for performing CRUD operations on Product entities.
 * Extends JpaRepository for additional JPA features like pagination and sorting.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
