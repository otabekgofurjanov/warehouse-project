package com.example.warehouseproject.web.rest;

import com.example.warehouseproject.service.ProductService;
import com.example.warehouseproject.service.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ProductResource {

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {
        ProductDTO result = productService.save(productDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO, @PathVariable Long id) {
        if (productDTO.getId() != null) {
            ProductDTO result = productService.update(productDTO);
            return ResponseEntity.ok(result);
        }
        return null;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAll(Pageable pageable) {
        Page<ProductDTO> result = productService.findAll(pageable);
        return ResponseEntity.ok().body(result.getContent());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> findOne(@PathVariable Long id) {
        Optional<ProductDTO> findOne = productService.findOne(id);
        return ResponseEntity.ok(findOne.get());
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok("Product deleted");
    }
}
