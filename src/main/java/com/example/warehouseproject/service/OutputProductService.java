package com.example.warehouseproject.service;

import com.example.warehouseproject.domain.OutputProduct;
import com.example.warehouseproject.repository.OutputProductRepository;
import com.example.warehouseproject.service.dto.OutputProductDTO;
import com.example.warehouseproject.service.mapper.OutputProductMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OutputProductService {

	private final OutputProductRepository outputProductRepository;
	private final OutputProductMapper outputProductMapper;

	public OutputProductService(OutputProductRepository outputProductRepository, OutputProductMapper outputProductMapper) {
		this.outputProductRepository = outputProductRepository;
		this.outputProductMapper = outputProductMapper;
	}

	public OutputProductDTO save(OutputProductDTO outputProductDTO) {
		if (outputProductDTO.getId() == null) {
			OutputProduct outputProduct = outputProductMapper.toEntity(outputProductDTO);
			outputProduct = outputProductRepository.save(outputProduct);
			return outputProductMapper.toDto(outputProduct);
		}
		return null;
	}

	public OutputProductDTO update(OutputProductDTO outputProductDTO) {
		OutputProduct outputProduct = outputProductMapper.toEntity(outputProductDTO);
		outputProduct = outputProductRepository.findOutputProductById(outputProduct.getId());
		if (outputProduct.getId() != null) {
			outputProduct.setOutput(outputProduct.getOutput());
			outputProduct.setProduct(outputProduct.getProduct());
			outputProduct.setPrice(outputProduct.getPrice());
			outputProduct.setAmount(outputProduct.getAmount());
			outputProduct = outputProductRepository.save(outputProduct);
			return outputProductMapper.toDto(outputProduct);
		}
		return null;
	}

	public Page<OutputProductDTO> findAll(Pageable pageable) {
		return outputProductRepository.findAll(pageable).map(outputProductMapper::toDto);
	}

	public Optional<OutputProductDTO> findOne(Long id) {
		if (id == null) {
			return null;
		}
		return outputProductRepository.findById(id).map(outputProductMapper::toDto);
	}

	public void delete(Long id) {
		outputProductRepository.deleteById(id);
	}


}
