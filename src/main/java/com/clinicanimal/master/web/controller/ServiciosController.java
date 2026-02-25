package com.clinicanimal.master.web.controller;

import com.clinicanimal.master.aplication.service.ServiciosService;
import com.clinicanimal.master.web.dto.servicios.ServiciosRequestDto;
import com.clinicanimal.master.web.dto.servicios.ServiciosResponseDto;
import com.clinicanimal.master.web.dto.servicios.ServiciosUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/servicios")
@RequiredArgsConstructor
public class ServiciosController {

    private final ServiciosService serviciosService;

    @GetMapping
    public ResponseEntity<List<ServiciosResponseDto>> listarServicios() {
        return ResponseEntity.ok(serviciosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiciosResponseDto> obtenerServicioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(serviciosService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ServiciosResponseDto> crearServicio(@Valid @RequestBody ServiciosRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviciosService.crearServicio(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiciosResponseDto> actualizarServicio(@PathVariable Long id,
                                                                   @Valid @RequestBody ServiciosUpdateDto dto) {
        return ResponseEntity.ok(serviciosService.actualizarServicio(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable Long id) {
        serviciosService.eliminarServicio(id);
        return ResponseEntity.noContent().build();
    }
}
