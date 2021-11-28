package com.example.warehouseproject.web.rest;

import com.example.warehouseproject.service.UserService;
import com.example.warehouseproject.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
        UserDTO result = userService.save(userDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/users")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        if (userDTO.getId() != null) {
            UserDTO result = userService.update(userDTO);
            return ResponseEntity.ok(result);
        }
        return null;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAll(Pageable pageable) {
        Page<UserDTO> result = userService.findAll(pageable);
        return ResponseEntity.ok().body(result.getContent());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> findOne(@PathVariable Long id) {
        Optional<UserDTO> findOne = userService.findOne(id);
        return ResponseEntity.ok(findOne.get());
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok("User deleted");
    }
}
