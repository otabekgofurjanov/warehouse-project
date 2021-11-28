package com.example.warehouseproject.web.rest;

import com.example.warehouseproject.service.InputProductService;
import com.example.warehouseproject.service.dto.InputProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class InputProductResource {

    private final InputProductService inputProductService;

    public InputProductResource(InputProductService inputProductService) {
        this.inputProductService = inputProductService;
    }

    @PostMapping("/input-product-resource")
    public ResponseEntity<InputProductDTO> save(@RequestBody InputProductDTO inputProductDTO) {
        InputProductDTO result = inputProductService.save(inputProductDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/input-product-resource/{id}")
    public ResponseEntity<InputProductDTO> update(@RequestBody InputProductDTO inputProductDTO, @PathVariable Long id) {
        if (inputProductDTO.getId() != null) {
            InputProductDTO result = inputProductService.update(inputProductDTO);
            return ResponseEntity.ok(result);
        }
        return null;
    }

    @GetMapping("/all/input-products")
    public ResponseEntity<List<InputProductDTO>> getAll(Pageable pageable) {
        Page<InputProductDTO> inputProductDTOPage = inputProductService.findAll(pageable);
        return ResponseEntity.ok().body(inputProductDTOPage.getContent());
    }

    @GetMapping("/input-products/{id}")
    public ResponseEntity<InputProductDTO> findOne(@PathVariable Long id) {
        Optional<InputProductDTO> findOne = inputProductService.findOne(id);
        return ResponseEntity.ok(findOne.get());
    }

    @DeleteMapping("/input-products/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        inputProductService.delete(id);
        return ResponseEntity.ok("Input product deleted");
    }
}
