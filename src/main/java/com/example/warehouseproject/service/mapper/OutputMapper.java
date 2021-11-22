package com.example.warehouseproject.service.mapper;

import com.example.warehouseproject.domain.Output;
import com.example.warehouseproject.service.dto.OutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, SupplierMapper.class, WarehouseMapper.class})
public interface OutputMapper extends EntityMapper<OutputDTO, Output> {

	@Mapping(source = "client.id", target = "clientId")
	@Mapping(source = "supplier.id", target = "supplierId")
	@Mapping(source = "warehouse.id", target = "warehouseId")
	OutputDTO toDto(Output output);

	@Mapping(source = "clientId", target = "client")
	@Mapping(source = "supplierId", target = "supplier")
	@Mapping(source = "warehouseId", target = "warehouse")
	Output toEntity(OutputDTO outputDTO);

	default Output fromId(Long id) {
		if (id == null) {
			return null;
		}

		Output output = new Output();
		output.setId(id);
		return output;
	}

}
