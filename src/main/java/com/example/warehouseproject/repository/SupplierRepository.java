package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("select s from Supplier s where s.id=:id")
    Supplier findSupplierById(@Param("id") Long id);
}
