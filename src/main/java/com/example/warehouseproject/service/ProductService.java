package com.example.warehouseproject.service;

import com.example.warehouseproject.domain.Product;
import com.example.warehouseproject.repository.ProductRepository;
import com.example.warehouseproject.service.dto.ProductDTO;
import com.example.warehouseproject.service.mapper.ProductMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	private final ProductMapper productMapper;

	public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	public ProductDTO save(ProductDTO productDTO) {
		if (productDTO.getId() == null) {
			Product product = productMapper.toEntity(productDTO);
			product = productRepository.save(product);
			return productMapper.toDto(product);
		}
		return null;
	}

	public ProductDTO update(ProductDTO productDTO) {
		Product product = productMapper.toEntity(productDTO);
		product = productRepository.findByProductId(product.getId());
		if (product.getId() != null) {
			product.setName(product.getName());
			product.setActive(product.getActive());
			product.setAttachment(product.getAttachment());
			product.setCategory(product.getCategory());
			product.setCode(product.getCode());
			product.setMeasurement(product.getMeasurement());
			product = productRepository.save(product);
			return productMapper.toDto(product);
		}
		return null;
	}

	public Page<ProductDTO> findAll(Pageable pageable) {
		return productRepository.findAll(pageable).map(productMapper::toDto);
	}

	public Optional<ProductDTO> findOne(Long id) {
		if (id == null) {
			return null;
		}
		return productRepository.findById(id).map(productMapper::toDto);
	}

	public void delete(Long id) {
		productRepository.deleteById(id);
	}
}
