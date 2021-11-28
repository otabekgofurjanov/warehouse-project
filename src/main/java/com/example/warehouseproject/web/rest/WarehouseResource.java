package com.example.warehouseproject.web.rest;

import com.example.warehouseproject.service.WarehouseService;
import com.example.warehouseproject.service.dto.WarehouseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class WarehouseResource {

    private final WarehouseService warehouseService;

    public WarehouseResource(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping("/warehouses")
    public ResponseEntity<WarehouseDTO> save(@RequestBody WarehouseDTO warehouseDTO) {
        WarehouseDTO result = warehouseService.save(warehouseDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/warehouses/{id}")
    public ResponseEntity<WarehouseDTO> update(@RequestBody WarehouseDTO warehouseDTO, @PathVariable Long id) {
        if (warehouseDTO.getId() != null) {
            WarehouseDTO result = warehouseService.update(warehouseDTO);
            return ResponseEntity.ok(result);
        }
        return null;
    }

    @GetMapping("/warehouses")
    public ResponseEntity<List<WarehouseDTO>> getAll(Pageable pageable) {
        Page<WarehouseDTO> getAll = warehouseService.findAll(pageable);
        return ResponseEntity.ok().body(getAll.getContent());
    }

    @GetMapping("/warehouses/{id}")
    public ResponseEntity<WarehouseDTO> findOne(@PathVariable Long id) {
        Optional<WarehouseDTO> findOne = warehouseService.findOne(id);
        return ResponseEntity.ok(findOne.get());
    }

    @DeleteMapping("/warehouses/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        warehouseService.delete(id);
        return ResponseEntity.ok("Warehouse deleted");
    }
}
