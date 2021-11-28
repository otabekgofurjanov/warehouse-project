package com.example.warehouseproject.web.rest;

import com.example.warehouseproject.service.OutputProductService;
import com.example.warehouseproject.service.dto.OutputProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OutputProductResource {

    private final OutputProductService outputProductService;

    public OutputProductResource(OutputProductService outputProductService) {
        this.outputProductService = outputProductService;
    }

    @PostMapping("/output-products")
    public ResponseEntity<OutputProductDTO> save(@RequestBody OutputProductDTO outputProductDTO) {
        OutputProductDTO result = outputProductService.save(outputProductDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/output-products/{id}")
    public ResponseEntity<OutputProductDTO> update(@RequestBody OutputProductDTO outputProductDTO, @PathVariable Long id) {
        if (outputProductDTO.getId() != null) {
            OutputProductDTO result = outputProductService.update(outputProductDTO);
            return ResponseEntity.ok(result);
        }
        return null;
    }

    @GetMapping("/output-products")
    public ResponseEntity<List<OutputProductDTO>> getAll(Pageable pageable) {
        Page<OutputProductDTO> result = outputProductService.findAll(pageable);
        return ResponseEntity.ok().body(result.getContent());
    }

    @GetMapping("/output-products/{id}")
    public ResponseEntity<OutputProductDTO> findOne(@PathVariable Long id) {
        Optional<OutputProductDTO> findOne = outputProductService.findOne(id);
        return ResponseEntity.ok(findOne.get());
    }

    @DeleteMapping("/output-products/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        outputProductService.delete(id);
        return ResponseEntity.ok("Output product deleted");
    }
}
