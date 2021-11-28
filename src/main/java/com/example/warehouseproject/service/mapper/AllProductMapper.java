package com.example.warehouseproject.service.mapper;


import com.example.warehouseproject.domain.AllProduct;
import com.example.warehouseproject.service.dto.AllProductDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface AllProductMapper extends EntityMapper<AllProductDTO, AllProduct> {

    @Mapping(source = "product.id", target = "product_id")
    AllProductDTO toDto(AllProduct allProduct);

    @Mapping(source = "product_id", target = "product")
    AllProduct toEntity(AllProductDTO allProductDTO);

    default AllProduct fromId(Long id) {
        if (id == null) {
            return null;
        }

        AllProduct allProduct = new AllProduct();
        allProduct.setId(id);
        return allProduct;
    }
}
