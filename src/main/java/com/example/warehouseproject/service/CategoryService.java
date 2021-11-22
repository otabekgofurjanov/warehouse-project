package com.example.warehouseproject.service;

import com.example.warehouseproject.domain.Category;
import com.example.warehouseproject.repository.CategoryRepository;
import com.example.warehouseproject.service.dto.CategoryDTO;
import com.example.warehouseproject.service.mapper.CategoryMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryDTO save(CategoryDTO categoryDTO) {
        if (categoryDTO.getId() == null) {
            Category category = categoryMapper.toEntity(categoryDTO);
            category = categoryRepository.save(category);
            return categoryMapper.toDto(category);
        }
        return null;
    }

    public CategoryDTO update(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        category = categoryRepository.findByCategoryId(category.getId());
        if (category.getId() != null) {
            category.setName(category.getName());
            category.setActive(category.isActive());
            category.setCategory(category.getCategory());
            category = categoryRepository.save(category);
            return categoryMapper.toDto(category);
        }
        return null;
    }

    public Page<CategoryDTO> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(categoryMapper::toDto);
    }

    public Optional<CategoryDTO> findOne(Long id) {
        if (id == null) {
            return null;
        }
        return categoryRepository.findById(id).map(categoryMapper::toDto);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
