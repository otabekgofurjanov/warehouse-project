package com.example.warehouseproject.service.mapper;

import com.example.warehouseproject.domain.Supplier;
import com.example.warehouseproject.service.dto.SupplierDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface SupplierMapper extends EntityMapper<SupplierDTO, Supplier> {

	default Supplier fromId(Long id) {
		if (id == null) {
			return null;
		}
		Supplier supplier = new Supplier();
		supplier.setId(id);
		return supplier;
	}

}
