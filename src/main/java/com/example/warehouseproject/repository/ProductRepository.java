package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByProductId(@Param("id") Long id);
}
