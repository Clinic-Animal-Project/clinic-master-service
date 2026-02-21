package com.clinicanimal.master.web.controller;

import com.clinicanimal.master.aplication.service.RolesService;
import com.clinicanimal.master.web.dto.roles.RolesRequestDto;
import com.clinicanimal.master.web.dto.roles.RolesResponseDto;
import com.clinicanimal.master.web.dto.roles.RolesUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RolesController {

    private final RolesService rolesService;

    @GetMapping
    public ResponseEntity<List<RolesResponseDto>> listarRoles() {
        return ResponseEntity.ok(rolesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolesResponseDto> obtenerRolPorId(@PathVariable Long id) {
        return ResponseEntity.ok(rolesService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RolesResponseDto> crearRol(@Valid @RequestBody RolesRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rolesService.crearRol(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolesResponseDto> actualizarRol(@PathVariable Long id,
                                                          @Valid @RequestBody RolesUpdateDto dto) {
        return ResponseEntity.ok(rolesService.actualizarRol(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        rolesService.eliminarRol(id);
        return ResponseEntity.noContent().build();
    }
}
