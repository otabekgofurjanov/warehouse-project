package com.example.warehouseproject.service.mapper;

import com.example.warehouseproject.domain.Output;
import com.example.warehouseproject.service.dto.OutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, SupplierMapper.class, WarehouseMapper.class})
public interface OutputMapper extends EntityMapper<OutputDTO, Output> {

	@Mapping(source = "client.id", target = "client_id")
	@Mapping(source = "supplier.id", target = "supplier_id")
	@Mapping(source = "warehouse.id", target = "warehouse_id")
	OutputDTO toDto(Output output);

	@Mapping(source = "client_id", target = "client")
	@Mapping(source = "supplier_id", target = "supplier")
	@Mapping(source = "warehouse_id", target = "warehouse")
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
