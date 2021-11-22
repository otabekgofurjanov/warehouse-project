package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.InputProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InputProductRepository extends JpaRepository<InputProduct, Long> {

	InputProduct findByInputProductId(@Param("id") Long id);

}
