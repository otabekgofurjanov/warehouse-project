package com.example.warehouseproject.web.rest;

import com.example.warehouseproject.service.CategoryService;
import com.example.warehouseproject.service.dto.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO result = categoryService.save(categoryDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/categories")
    public ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO categoryDTO, @PathVariable Long id) {
        CategoryDTO result = categoryService.update(categoryDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/all-categories")
    public ResponseEntity<List<CategoryDTO>> findAllPaging(Pageable pageable) {
        Page<CategoryDTO> categoryDTOPage = categoryService.findAll(pageable);
        return ResponseEntity.ok().body(categoryDTOPage.getContent());
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> findOne(@PathVariable Long id) {
        Optional<CategoryDTO> findOne = categoryService.findOne(id);
        return ResponseEntity.ok(findOne.get());
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity delete (@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.ok("Categories deleted");
    }


}
