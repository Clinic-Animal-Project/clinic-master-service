package com.clinicanimal.master.web.controller;

import com.clinicanimal.master.aplication.service.AreaService;
import com.clinicanimal.master.web.dto.area.AreaRequestDto;
import com.clinicanimal.master.web.dto.area.AreaResponseDto;
import com.clinicanimal.master.web.dto.area.AreaUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areas")
@RequiredArgsConstructor
public class AreaController {

    private final AreaService areaService;

    @GetMapping
    public ResponseEntity<List<AreaResponseDto>> listarAreas() {
        return ResponseEntity.ok(areaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaResponseDto> obtenerAreaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(areaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AreaResponseDto> crearArea(@Valid @RequestBody AreaRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(areaService.crearArea(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaResponseDto> actualizarArea(@PathVariable Long id,
                                                          @Valid @RequestBody AreaUpdateDto dto) {
        return ResponseEntity.ok(areaService.actualizarArea(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarArea(@PathVariable Long id) {
        areaService.eliminarArea(id);
        return ResponseEntity.noContent().build();
    }
}
