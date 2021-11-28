package com.example.warehouseproject.web.rest;

import com.example.warehouseproject.service.OutputService;
import com.example.warehouseproject.service.dto.OutputDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OutputResource {

    private final OutputService outputService;

    public OutputResource(OutputService outputService) {
        this.outputService = outputService;
    }

    @PostMapping("/outputs")
    public ResponseEntity<OutputDTO> save(@RequestBody OutputDTO outputDTO) {
        OutputDTO result = outputService.save(outputDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/outputs/{id}")
    public ResponseEntity<OutputDTO> update(@RequestBody OutputDTO outputDTO, @PathVariable Long id) {
        if (outputDTO.getId() != null) {
            OutputDTO result = outputService.update(outputDTO);
            return ResponseEntity.ok(result);
        }
        return null;
    }

    @GetMapping("/outputs")
    public ResponseEntity<List<OutputDTO>> getAll(Pageable pageable) {
        Page<OutputDTO> outputDTOPage = outputService.findAll(pageable);
        return ResponseEntity.ok().body(outputDTOPage.getContent());
    }

    @GetMapping("/outputs/{id}")
    public ResponseEntity<OutputDTO> findOne(@PathVariable Long id) {
        Optional<OutputDTO> findOne = outputService.findOne(id);
        return ResponseEntity.ok(findOne.get());
    }

    @DeleteMapping("/outputs/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        outputService.delete(id);
        return ResponseEntity.ok("Output deleted");
    }
}
