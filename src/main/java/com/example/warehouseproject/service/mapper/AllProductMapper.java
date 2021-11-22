package com.example.warehouseproject.service.mapper;


import com.example.warehouseproject.domain.AllProduct;
import com.example.warehouseproject.service.dto.AllProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface AllProductMapper extends EntityMapper<AllProductDTO, AllProduct> {

    @Mapping(source = "product.id", target = "productId")
    AllProductDTO toDto(AllProduct allProduct);

    @Mapping(source = "productId", target = "product")
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
