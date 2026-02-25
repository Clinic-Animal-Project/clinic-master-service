package com.clinicanimal.master.web.controller;

import com.clinicanimal.master.aplication.service.PersonalService;
import com.clinicanimal.master.domain.model.estado.EstadoPersonal;
import com.clinicanimal.master.web.dto.personal.PersonalRequestDto;
import com.clinicanimal.master.web.dto.personal.PersonalResponseDto;
import com.clinicanimal.master.web.dto.personal.PersonalUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/personal")
@RequiredArgsConstructor
public class PersonalController {

    private final PersonalService personalService;

    @GetMapping
    public ResponseEntity<List<PersonalResponseDto>> listarPersonal() {
        return ResponseEntity.ok(personalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalResponseDto> obtenerPersonalPorId(@PathVariable Long id) {
        return ResponseEntity.ok(personalService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PersonalResponseDto> crearPersonal(@Valid @RequestBody PersonalRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personalService.crearPersonal(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalResponseDto> actualizarPersonal(@PathVariable Long id,
                                                                  @Valid @RequestBody PersonalUpdateDto dto) {
        return ResponseEntity.ok(personalService.actualizarPersonal(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersonal(@PathVariable Long id) {
        personalService.eliminarPersonal(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<PersonalResponseDto> actualizarEstado(@PathVariable Long id,
                                                                      @RequestParam EstadoPersonal estado) {
        PersonalResponseDto  personal =  personalService.actualizarEstado(id,estado);
        return ResponseEntity.ok(personal);
    }
}
