package com.example.warehouseproject.service.mapper;


import com.example.warehouseproject.domain.Product;
import com.example.warehouseproject.service.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {MeasurementMapper.class, CategoryMapper.class})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {

    @Mapping(source = "measurement.id", target = "measurement_id")
    @Mapping(source = "category.id", target = "category_id")
    ProductDTO toDto(Product product);

    @Mapping(source = "measurement_id", target = "measurement")
    @Mapping(source = "category_id", target = "category")
    Product toEntity(ProductDTO productDTO);

    default Product fromId(Long id) {
        if (id == null) {
            return null;
        }

        Product product = new Product();
        product.setId(id);
        return product;
    }

}
