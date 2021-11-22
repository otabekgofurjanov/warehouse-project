package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Currency findByCurrenceId(@Param("id") Long id);
}
