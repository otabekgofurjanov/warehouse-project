package com.example.warehouseproject.service;


import com.example.warehouseproject.domain.Measurement;
import com.example.warehouseproject.repository.MeasurementRepository;
import com.example.warehouseproject.service.dto.MeasurementDTO;
import com.example.warehouseproject.service.mapper.MeasurementMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MeasurementService {

	private final MeasurementRepository measurementRepository;
	private final MeasurementMapper measurementMapper;

	public MeasurementService(MeasurementRepository measurementRepository, MeasurementMapper measurementMapper) {
		this.measurementRepository = measurementRepository;
		this.measurementMapper = measurementMapper;
	}

	public MeasurementDTO save(MeasurementDTO measurementDTO) {
		if (measurementDTO.getId() == null) {
			Measurement measurement = measurementMapper.toEntity(measurementDTO);
			measurement = measurementRepository.save(measurement);
			return measurementMapper.toDto(measurement);
		}
		return null;
	}

	public MeasurementDTO update(MeasurementDTO measurementDTO) {
		Measurement measurement = measurementMapper.toEntity(measurementDTO);
		measurement = measurementRepository.findMeasurementById(measurement.getId());
		if (measurement.getId() != null) {
			measurement.setName(measurement.getName());
			measurement.setActive(measurement.isActive());
			measurement = measurementRepository.save(measurement);
			return measurementMapper.toDto(measurement);
		}
		return null;
	}

	public Page<MeasurementDTO> findAll(Pageable pageable) {
		return measurementRepository.findAll(pageable).map(measurementMapper::toDto);
	}

	public Optional<MeasurementDTO> findOne(Long id) {
		if (id == null) {
			return null;
		}
		return measurementRepository.findById(id).map(measurementMapper::toDto);
	}

	public void delete(Long id) {
		measurementRepository.deleteById(id);
	}
}
