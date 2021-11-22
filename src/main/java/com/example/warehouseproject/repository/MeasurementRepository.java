package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

	Measurement findByMeasurementId(@Param("id") Long id);
}
