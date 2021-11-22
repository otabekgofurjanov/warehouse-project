package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.Input;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InputRepository extends JpaRepository<Input, Long> {

	Input findByInputId(@Param("id") Long id);
}
