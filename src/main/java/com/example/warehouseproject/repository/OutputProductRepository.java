package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.OutputProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OutputProductRepository extends JpaRepository<OutputProduct, Long> {

    @Query("select op from OutputProduct op where op.id =:id")
    OutputProduct findOutputProductById(@Param("id") Long id);
}
