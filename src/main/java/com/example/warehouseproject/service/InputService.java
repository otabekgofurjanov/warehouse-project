package com.example.warehouseproject.service;

import com.example.warehouseproject.domain.Input;
import com.example.warehouseproject.repository.InputRepository;
import com.example.warehouseproject.service.dto.InputDTO;
import com.example.warehouseproject.service.mapper.InputMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InputService {

	private final InputRepository inputRepository;
	private final InputMapper inputMapper;

	public InputService(InputRepository inputRepository, InputMapper inputMapper) {
		this.inputRepository = inputRepository;
		this.inputMapper = inputMapper;
	}

	public InputDTO save(InputDTO inputDTO) {
		if (inputDTO.getId() == null) {
			Input input = inputMapper.toEntity(inputDTO);
			input = inputRepository.save(input);
			return inputMapper.toDto(input);
		}
		return null;
	}

	public InputDTO update(InputDTO inputDTO) {
		Input input = inputMapper.toEntity(inputDTO);
		input = inputRepository.findByInputId(input.getId());
		if (input.getId() != null) {
			input.setCode(input.getCode());
			input.setDate(input.getDate());
			input.setFactureNumber(input.getFactureNumber());
			input.setCurrency(input.getCurrency());
			input.setSupplier(input.getSupplier());
			input.setWarehouse(input.getWarehouse());
			input = inputRepository.save(input);
			return inputMapper.toDto(input);
		}
		return null;
	}

	public Page<InputDTO> findAll(Pageable pageable) {
		return inputRepository.findAll(pageable).map(inputMapper::toDto);
	}

	public Optional<InputDTO> findOne(Long id) {
		if (id == null) {
			return null;
		}
		return inputRepository.findById(id).map(inputMapper::toDto);
	}

	public void delete(Long id) {
		inputRepository.deleteById(id);
	}
}
