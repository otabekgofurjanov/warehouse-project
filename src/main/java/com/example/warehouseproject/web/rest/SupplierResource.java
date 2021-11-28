package com.example.warehouseproject.web.rest;

import com.example.warehouseproject.service.SupplierService;
import com.example.warehouseproject.service.dto.SupplierDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SupplierResource {

    private final SupplierService supplierService;

    public SupplierResource(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/suppliers")
    public ResponseEntity<SupplierDTO> save(@RequestBody SupplierDTO supplierDTO) {
        SupplierDTO result = supplierService.save(supplierDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/suppliers/{id}")
    public ResponseEntity<SupplierDTO> update(@RequestBody SupplierDTO supplierDTO, @PathVariable Long id) {
        if (supplierDTO.getId() != null) {
            SupplierDTO result = supplierService.update(supplierDTO);
            return ResponseEntity.ok(result);
        }
        return null;
    }

    @GetMapping("/suppliers")
    public ResponseEntity<List<SupplierDTO>> getAll(Pageable pageable) {
        Page<SupplierDTO> result = supplierService.findAll(pageable);
        return ResponseEntity.ok().body(result.getContent());
    }

    @GetMapping("/suppliers/{id}")
    public ResponseEntity<SupplierDTO> findOne(@PathVariable Long id) {
        Optional<SupplierDTO> findOne = supplierService.findOne(id);
        return ResponseEntity.ok(findOne.get());
    }

    @DeleteMapping("/suppliers/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        supplierService.delete(id);
        return ResponseEntity.ok("Supplier deleted");
    }
}
