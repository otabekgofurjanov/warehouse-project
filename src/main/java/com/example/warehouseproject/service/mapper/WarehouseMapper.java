package com.example.warehouseproject.service.mapper;


import com.example.warehouseproject.domain.Warehouse;
import com.example.warehouseproject.service.dto.WarehouseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface WarehouseMapper extends EntityMapper<WarehouseDTO, Warehouse> {

	default Warehouse fromId(Long id) {
		if (id == null) {
			return null;
		}
		Warehouse warehouse = new Warehouse();
		warehouse.setId(id);
		return warehouse;
	}
}
