package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.InputProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InputProductRepository extends JpaRepository<InputProduct, Long> {

    @Query("select ip from InputProduct ip where ip.id =:id")
    InputProduct findInputProductById(@Param("id") Long id);

}
