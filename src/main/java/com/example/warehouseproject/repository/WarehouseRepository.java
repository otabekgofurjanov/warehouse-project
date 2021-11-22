package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

	Warehouse findByWarehouseId(@Param("id") Long id);
}

