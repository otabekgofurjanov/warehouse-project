package com.example.warehouseproject.service.mapper;

import com.example.warehouseproject.domain.Measurement;
import com.example.warehouseproject.service.dto.MeasurementDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface MeasurementMapper extends EntityMapper<MeasurementDTO, Measurement> {

	default Measurement fromId(Long id) {
		if (id == null) {
			return null;
		}

		Measurement measurement = new Measurement();
		measurement.setId(id);
		return measurement;
	}
}
