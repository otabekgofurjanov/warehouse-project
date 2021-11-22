package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	Supplier findBySupplierId(@Param("id") Long id);

}
