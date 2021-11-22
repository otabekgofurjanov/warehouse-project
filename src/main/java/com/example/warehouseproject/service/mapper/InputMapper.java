package com.example.warehouseproject.service.mapper;

import com.example.warehouseproject.domain.Input;
import com.example.warehouseproject.service.dto.InputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CurrencyMapper.class, SupplierMapper.class, WarehouseMapper.class})
public interface InputMapper extends EntityMapper<InputDTO, Input> {

	@Mapping(source = "currency.id", target = "currencyId")
	@Mapping(source = "supplier.id", target = "supplierId")
	@Mapping(source = "warehouse.id", target = "warehouseId")
	InputDTO toDto(Input input);

	@Mapping(source = "clientId", target = "client")
	@Mapping(source = "supplierId", target = "supplier")
	@Mapping(source = "warehouseId", target = "warehouse")
	Input toEntity(InputDTO inputDTO);

	default Input fromId(Long id) {
		if (id == null) {
			return null;
		}

		Input input = new Input();
		input.setId(id);
		return input;

	}

}
