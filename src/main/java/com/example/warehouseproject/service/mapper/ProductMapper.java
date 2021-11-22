package com.example.warehouseproject.service.mapper;


import com.example.warehouseproject.domain.Product;
import com.example.warehouseproject.service.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {MeasurementMapper.class, CategoryMapper.class})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {

    @Mapping(source = "measurement.id", target = "measurementId")
    @Mapping(source = "category.id", target = "categoryId")
    ProductDTO toDto(Product product);

    @Mapping(source = "measurementId", target = "measurement")
    @Mapping(source = "categoryId", target = "category")
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
