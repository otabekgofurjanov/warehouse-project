package com.example.warehouseproject.service;

import com.example.warehouseproject.domain.Supplier;
import com.example.warehouseproject.repository.SupplierRepository;
import com.example.warehouseproject.service.dto.SupplierDTO;
import com.example.warehouseproject.service.mapper.SupplierMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierService {

	private final SupplierRepository supplierRepository;
	private final SupplierMapper supplierMapper;

	public SupplierService(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {
		this.supplierRepository = supplierRepository;
		this.supplierMapper = supplierMapper;
	}

	public SupplierDTO save(SupplierDTO supplierDTO) {
		if (supplierDTO.getId() == null) {
			Supplier supplier = supplierMapper.toEntity(supplierDTO);
			supplier = supplierRepository.save(supplier);
			return supplierMapper.toDto(supplier);
		}
		return null;
	}

	public SupplierDTO update(SupplierDTO supplierDTO) {
		Supplier supplier = supplierMapper.toEntity(supplierDTO);
		supplier = supplierRepository.findBySupplierId(supplier.getId());
		if (supplier.getId() != null) {
			supplier.setName(supplier.getName());
			supplier.setPhoneNumber(supplier.getPhoneNumber());
			supplier.setActive(supplier.isActive());
			supplier = supplierRepository.save(supplier);
			return supplierMapper.toDto(supplier);
		}
		return null;
	}

	public Page<SupplierDTO> findAll(Pageable pageable) {
		return supplierRepository.findAll(pageable).map(supplierMapper::toDto);
	}

	public Optional<SupplierDTO> findOne(Long id) {
		if (id == null) {
			return null;
		}
		return supplierRepository.findById(id).map(supplierMapper::toDto);
	}

	public void delete(Long id) {
		supplierRepository.deleteById(id);
	}
}
