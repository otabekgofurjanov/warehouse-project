package com.example.warehouseproject.service;

import com.example.warehouseproject.domain.InputProduct;
import com.example.warehouseproject.repository.InputProductRepository;
import com.example.warehouseproject.service.dto.InputProductDTO;
import com.example.warehouseproject.service.mapper.InputProductMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InputProductService {

	private final InputProductRepository inputProductRepository;
	private final InputProductMapper inputProductMapper;

	public InputProductService(InputProductRepository inputProductRepository, InputProductMapper inputProductMapper) {
		this.inputProductRepository = inputProductRepository;
		this.inputProductMapper = inputProductMapper;
	}

	public InputProductDTO save(InputProductDTO inputProductDTO) {
		if (inputProductDTO.getId() == null) {
			InputProduct inputProduct = inputProductMapper.toEntity(inputProductDTO);
			inputProduct = inputProductRepository.save(inputProduct);
			return inputProductMapper.toDto(inputProduct);
		}
		return null;
	}

	public InputProductDTO update(InputProductDTO inputProductDTO) {
		InputProduct inputProduct = inputProductMapper.toEntity(inputProductDTO);
		inputProduct = inputProductRepository.findInputProductById(inputProduct.getId());
		if (inputProduct.getId() != null) {
			inputProduct.setProduct(inputProduct.getProduct());
			inputProduct.setInput(inputProduct.getInput());
			inputProduct.setPrice(inputProduct.getPrice());
			inputProduct.setAmount(inputProduct.getAmount());
			inputProduct.setDate(inputProduct.getDate());
			inputProduct = inputProductRepository.save(inputProduct);
			return inputProductMapper.toDto(inputProduct);
		}
		return null;
	}

	public Page<InputProductDTO> findAll(Pageable pageable) {
		return inputProductRepository.findAll(pageable).map(inputProductMapper::toDto);
	}

	public Optional<InputProductDTO> findOne(Long id) {
		if (id == null) {
			return null;
		}
		return inputProductRepository.findById(id).map(inputProductMapper::toDto);
	}

	public void delete(Long id) {
		inputProductRepository.deleteById(id);
	}
}
