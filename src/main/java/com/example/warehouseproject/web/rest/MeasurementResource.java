package com.example.warehouseproject.web.rest;

import com.example.warehouseproject.service.MeasurementService;
import com.example.warehouseproject.service.dto.MeasurementDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MeasurementResource {

    private final MeasurementService measurementService;

    public MeasurementResource(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping("/measurements")
    public ResponseEntity<MeasurementDTO> save(@RequestBody MeasurementDTO measurementDTO) {
        MeasurementDTO result = measurementService.save(measurementDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/measurements/{id}")
    public ResponseEntity<MeasurementDTO> update(@RequestBody MeasurementDTO measurementDTO, @PathVariable Long id) {
        if (measurementDTO.getId() != null) {
            MeasurementDTO result = measurementService.update(measurementDTO);
            return ResponseEntity.ok(result);
        }
        return null;
    }

    @GetMapping("/measurements")
    public ResponseEntity<List<MeasurementDTO>> getAll(Pageable pageable) {
        Page<MeasurementDTO> measurementDTOPage = measurementService.findAll(pageable);
        return ResponseEntity.ok().body(measurementDTOPage.getContent());
    }

    @GetMapping("/measurements/{id}")
    public ResponseEntity<MeasurementDTO> findOne(@PathVariable Long id) {
        Optional<MeasurementDTO> measurementDTO = measurementService.findOne(id);
        return ResponseEntity.ok(measurementDTO.get());
    }

    @DeleteMapping("/measurements/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        measurementService.delete(id);
        return ResponseEntity.ok("Measurement deleted");
    }
}
