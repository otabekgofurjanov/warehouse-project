package com.example.warehouseproject.service.mapper;

import com.example.warehouseproject.domain.OutputProduct;
import com.example.warehouseproject.service.dto.OutputProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {OutputMapper.class, ProductMapper.class})
public interface OutputProductMapper extends EntityMapper<OutputProductDTO, OutputProduct> {

	@Mapping(source = "output.id", target = "output_id")
	@Mapping(source = "product.id", target = "product_id")
	OutputProductDTO toDto(OutputProduct outputProduct);

	@Mapping(source = "output_id", target = "output")
	@Mapping(source = "product_id", target = "product")
	OutputProduct toEntity(OutputProductDTO outputProductDTO);

	default OutputProduct fromId(Long id) {
		if (id == null) {
			return null;
		}

		OutputProduct outputProduct = new OutputProduct();
		outputProduct.setId(id);
		return outputProduct;
	}
}
