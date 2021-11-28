package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.AllProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AllProductRepository extends JpaRepository<AllProduct, Long> {

    @Query("select ap from AllProduct ap where ap.id = :id")
    AllProduct findAllProductById(@Param("id") Long id);
}
