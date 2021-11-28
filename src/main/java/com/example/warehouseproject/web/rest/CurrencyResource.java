package com.example.warehouseproject.web.rest;

import com.example.warehouseproject.service.CurrencyService;
import com.example.warehouseproject.service.dto.CurrencyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CurrencyResource {

    private final CurrencyService currencyService;

    public CurrencyResource(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping("/currencies")
    public ResponseEntity<CurrencyDTO> save(@RequestBody CurrencyDTO currencyDTO) {
        CurrencyDTO result = currencyService.save(currencyDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/currencies/{id}")
    public ResponseEntity<CurrencyDTO> update(@RequestBody CurrencyDTO currencyDTO, @PathVariable Long id) {
        if (currencyDTO.getId() != null) {
            CurrencyDTO result = currencyService.update(currencyDTO);
            return ResponseEntity.ok(currencyDTO);
        }
        return null;
    }

    @GetMapping("/currencies")
    public ResponseEntity<List<CurrencyDTO>> getAllCurrency(Pageable pageable) {
        Page<CurrencyDTO> findAll = currencyService.getAll(pageable);
        return ResponseEntity.ok().body(findAll.getContent());
    }

    @GetMapping("/currencies/{id}")
    public ResponseEntity<CurrencyDTO> findOne(@PathVariable Long id) {
        Optional<CurrencyDTO> optionalCurrencyDTO = currencyService.findOne(id);
        return ResponseEntity.ok().body(optionalCurrencyDTO.get());
    }

    @DeleteMapping("/currencies/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        currencyService.delete(id);
        return ResponseEntity.ok("Currency deleted");
    }
}
