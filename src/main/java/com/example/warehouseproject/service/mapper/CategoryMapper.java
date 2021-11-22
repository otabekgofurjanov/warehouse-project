package com.example.warehouseproject.service.mapper;

import com.example.warehouseproject.domain.Category;
import com.example.warehouseproject.service.dto.CategoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category>{

	default Category fromId(Long id){
		if (id == null){
			return null;
		}

		Category category = new Category();
		category.setId(id);
		return category;
	}
}
