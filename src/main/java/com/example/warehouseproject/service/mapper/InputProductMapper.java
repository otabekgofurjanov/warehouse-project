package com.example.warehouseproject.service.mapper;

import com.example.warehouseproject.domain.InputProduct;
import com.example.warehouseproject.service.dto.InputProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {InputMapper.class, ProductMapper.class})
public interface InputProductMapper extends EntityMapper<InputProductDTO, InputProduct> {

	@Mapping(source = "input.id", target = "inputId")
	@Mapping(source = "product.id", target = "productId")
	InputProductDTO toDto(InputProduct inputProduct);

	@Mapping(source = "inputId", target = "input")
	@Mapping(source = "productId", target = "product")
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
