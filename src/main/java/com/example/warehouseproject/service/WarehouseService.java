package com.example.warehouseproject.service;

import com.example.warehouseproject.domain.Warehouse;
import com.example.warehouseproject.repository.WarehouseRepository;
import com.example.warehouseproject.service.dto.WarehouseDTO;
import com.example.warehouseproject.service.mapper.WarehouseMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarehouseService {

	private final WarehouseRepository warehouseRepository;
	private final WarehouseMapper warehouseMapper;

	public WarehouseService(WarehouseRepository warehouseRepository, WarehouseMapper warehouseMapper) {
		this.warehouseRepository = warehouseRepository;
		this.warehouseMapper = warehouseMapper;
	}

	public WarehouseDTO save(WarehouseDTO warehouseDTO) {
		if (warehouseDTO.getId() == null) {
			Warehouse warehouse = warehouseMapper.toEntity(warehouseDTO);
			warehouse = warehouseRepository.save(warehouse);
			return warehouseMapper.toDto(warehouse);
		}
		return null;
	}

	public WarehouseDTO update(WarehouseDTO warehouseDTO) {
		Warehouse warehouse = warehouseMapper.toEntity(warehouseDTO);
		warehouse = warehouseRepository.findWarehouseById(warehouse.getId());
		if (warehouse.getId() != null) {
			warehouse.setName(warehouse.getName());
			warehouse.setActive(warehouse.isActive());
			warehouse = warehouseRepository.save(warehouse);
			return warehouseMapper.toDto(warehouse);
		}
		return null;
	}

	public Page<WarehouseDTO> findAll(Pageable pageable) {
		return warehouseRepository.findAll(pageable).map(warehouseMapper::toDto);
	}

	public Optional<WarehouseDTO> findOne(Long id) {
		if (id == null) {
			return null;
		}
		return warehouseRepository.findById(id).map(warehouseMapper::toDto);
	}

	public void delete(Long id) {
		warehouseRepository.deleteById(id);
	}
}
