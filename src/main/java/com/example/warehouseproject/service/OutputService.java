package com.example.warehouseproject.service;

import com.example.warehouseproject.domain.Output;
import com.example.warehouseproject.repository.OutputRepository;
import com.example.warehouseproject.service.dto.OutputDTO;
import com.example.warehouseproject.service.mapper.OutputMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OutputService {

	private final OutputRepository outputRepository;
	private final OutputMapper outputMapper;

	public OutputService(OutputRepository outputRepository, OutputMapper outputMapper) {
		this.outputRepository = outputRepository;
		this.outputMapper = outputMapper;
	}

	public OutputDTO save(OutputDTO outputDTO) {
		if (outputDTO.getId() == null) {
			Output output = outputMapper.toEntity(outputDTO);
			output = outputRepository.save(output);
			return outputMapper.toDto(output);
		}
		return null;
	}

	public OutputDTO update(OutputDTO outputDTO) {
		Output output = outputMapper.toEntity(outputDTO);
		output = outputRepository.findByOutputId(output.getId());
		if (output.getId() != null) {
			output.setCode(output.getCode());
			output.setClient(output.getClient());
			output.setDate(output.getDate());
			output.setSupplier(output.getSupplier());
			output.setClient(output.getClient());
			output.setFactureNumber(output.getFactureNumber());
			output.setWarehouse(output.getWarehouse());
			output = outputRepository.save(output);
			return outputMapper.toDto(output);
		}
		return null;
	}

	public Page<OutputDTO> findAll(Pageable pageable) {
		return outputRepository.findAll(pageable).map(outputMapper::toDto);
	}

	public Optional<OutputDTO> findOne(Long id) {
		if (id == null) {
			return null;
		}
		return outputRepository.findById(id).map(outputMapper::toDto);
	}

	public void delete(Long id) {
		outputRepository.deleteById(id);
	}
}
