package com.clinicanimal.master.web.controller;

import com.clinicanimal.master.aplication.service.MascotaService;
import com.clinicanimal.master.web.dto.mascota.MascotaRequestDto;
import com.clinicanimal.master.web.dto.mascota.MascotaResponseDto;
import com.clinicanimal.master.web.dto.mascota.MascotaUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
@RequiredArgsConstructor
public class MascotaController {

    private final MascotaService mascotaService;

    @GetMapping
    public ResponseEntity<List<MascotaResponseDto>> listarMascotas() {
        return ResponseEntity.ok(mascotaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaResponseDto> obtenerMascotaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mascotaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MascotaResponseDto> crearMascota(@Valid @RequestBody MascotaRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mascotaService.crearMascota(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MascotaResponseDto> actualizarMascota(@PathVariable Long id,
                                                                @Valid @RequestBody MascotaUpdateDto dto) {
        return ResponseEntity.ok(mascotaService.actualizarMascota(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMascota(@PathVariable Long id) {
        mascotaService.eliminarMascota(id);
        return ResponseEntity.noContent().build();
    }
}

