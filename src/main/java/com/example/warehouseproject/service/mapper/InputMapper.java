package com.example.warehouseproject.service.mapper;

import com.example.warehouseproject.domain.Input;
import com.example.warehouseproject.service.dto.InputDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {CurrencyMapper.class, SupplierMapper.class, WarehouseMapper.class})
public interface InputMapper extends EntityMapper<InputDTO, Input> {

	@Mapping(source = "currency.id", target = "currency_id")
	@Mapping(source = "supplier.id", target = "supplier_id")
	@Mapping(source = "warehouse.id", target = "warehouse_id")
	InputDTO toDto(Input input);

	@Mapping(source = "currency_id", target = "currency")
	@Mapping(source = "supplier_id", target = "supplier")
	@Mapping(source = "warehouse_id", target = "warehouse")
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
