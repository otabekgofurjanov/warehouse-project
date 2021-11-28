package com.example.warehouseproject.web.rest;

import com.example.warehouseproject.service.InputService;
import com.example.warehouseproject.service.dto.InputDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class InputResource {

    private final InputService inputService;

    public InputResource(InputService inputService) {
        this.inputService = inputService;
    }

    @PostMapping("/inputs")
    public ResponseEntity<InputDTO> save(@RequestBody InputDTO inputDTO) {
        InputDTO result = inputService.save(inputDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/inputs/{id}")
    public ResponseEntity<InputDTO> update(@RequestBody InputDTO inputDTO, @PathVariable Long id) {
        if (inputDTO.getId() != null) {
            InputDTO result = inputService.update(inputDTO);
            return ResponseEntity.ok(result);
        }
        return null;
    }

    @GetMapping("/inputs")
    public ResponseEntity<List<InputDTO>> getAll(Pageable pageable) {
        Page<InputDTO> inputDTOPage = inputService.findAll(pageable);
        return ResponseEntity.ok().body(inputDTOPage.getContent());
    }

    @GetMapping("/inputs/{id}")
    public ResponseEntity<InputDTO> findOne(@PathVariable Long id) {
        Optional<InputDTO> inputDTOOptional = inputService.findOne(id);
        return ResponseEntity.ok().body(inputDTOOptional.get());
    }

    @DeleteMapping("/inputs/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        inputService.delete(id);
        return ResponseEntity.ok("Input deleted");
    }
}
