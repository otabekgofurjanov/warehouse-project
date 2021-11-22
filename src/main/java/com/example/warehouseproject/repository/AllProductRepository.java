package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.AllProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AllProductRepository extends JpaRepository<AllProduct, Long> {

    AllProduct findByAllProductId(@Param("id") Long id);
}
