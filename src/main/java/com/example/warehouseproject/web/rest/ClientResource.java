package com.example.warehouseproject.web.rest;

import com.example.warehouseproject.service.ClientService;
import com.example.warehouseproject.service.dto.ClientDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientResource {

    private final ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    public ResponseEntity<ClientDTO> save(@RequestBody ClientDTO clientDTO) {
        ClientDTO result = clientService.save(clientDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<ClientDTO> update(@RequestBody ClientDTO clientDTO, @PathVariable Long id) {
        if (clientDTO.getId() != null) {
            ClientDTO result = clientService.update(clientDTO);
            return ResponseEntity.ok(result);
        }
        return null;
    }

    @GetMapping("/clients/all")
    public ResponseEntity<List<ClientDTO>> findAllClients(Pageable pageable) {
        Page<ClientDTO> clientDTOPage = clientService.findAll(pageable);
        return ResponseEntity.ok().body(clientDTOPage.getContent());
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientDTO> findOne(@PathVariable Long id) {
        Optional<ClientDTO> findOne = clientService.findOne(id);
        return ResponseEntity.ok(findOne.get());
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.ok("Client deleted");
    }
}
