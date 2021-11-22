package com.example.warehouseproject.rest;

import com.example.warehouseproject.service.AllProductService;
import com.example.warehouseproject.service.dto.AllProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AllProductResource {

	private final AllProductService allProductService;

	public AllProductResource(AllProductService allProductService) {
		this.allProductService = allProductService;
	}

	@PostMapping("/all-product")
	public ResponseEntity<AllProductDTO> save(@RequestBody AllProductDTO allProductDTO) {
		AllProductDTO result = allProductService.save(allProductDTO);
		return ResponseEntity.ok(result);
	}

	@PutMapping("/all-product/{id}")
	public ResponseEntity<AllProductDTO> update(@RequestBody AllProductDTO allProductDTO, @PathVariable Long id) {
		AllProductDTO productDTO = allProductService.update(allProductDTO);
		return ResponseEntity.ok(allProductDTO);
	}

	@GetMapping("/all-product")
	public ResponseEntity<List<AllProductDTO>> findAllPaging(Pageable pageable) {
		Page<AllProductDTO> page = allProductService.findAll(pageable);
		return ResponseEntity.ok().body(page.getContent());
	}

	@GetMapping("/all-product/{id}")
	public ResponseEntity<AllProductDTO> getOne(@PathVariable Long id) {
		Optional<AllProductDTO> optional = allProductService.findOne(id);
		return ResponseEntity.ok(optional.get());
	}

	@DeleteMapping("/all-product/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		allProductService.delete(id);
		return ResponseEntity.ok("Delete Category");
	}


}
