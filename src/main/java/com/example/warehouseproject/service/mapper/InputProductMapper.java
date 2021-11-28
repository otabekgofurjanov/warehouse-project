package com.example.warehouseproject.service.mapper;

import com.example.warehouseproject.domain.InputProduct;
import com.example.warehouseproject.service.dto.InputProductDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {InputMapper.class, ProductMapper.class})
public interface InputProductMapper extends EntityMapper<InputProductDTO, InputProduct> {

	@Mapping(source = "input.id", target = "input_id")
	@Mapping(source = "product.id", target = "product_id")
	InputProductDTO toDto(InputProduct inputProduct);

	@Mapping(source = "input_id", target = "input")
	@Mapping(source = "product_id", target = "product")
	InputProduct toEntity(InputProductDTO inputProductDTO);

	default InputProduct fromId(Long id) {
		if (id == null) {
			return null;
		}

		InputProduct inputProduct = new InputProduct();
		inputProduct.setId(id);
		return inputProduct;
	}
}
