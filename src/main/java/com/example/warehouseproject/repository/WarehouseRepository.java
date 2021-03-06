package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    @Query("select w from Warehouse w where w.id =:id")
    Warehouse findWarehouseById(@Param("id") Long id);
}

