package com.clinicanimal.master.web.dto.personal;

import com.clinicanimal.master.domain.model.estado.EstadoPersonal;

import java.time.LocalDate;

public record PersonalResponseDto(
        Long id,
        String nombrePersonal,
        String apellidoPersonal,
        int edad,
        String dni,
        String email,
        String telefono,
        Long idRol,
        String nombreRol,
        Long idArea,
        String nomArea,
        LocalDate fechaRegistro,
        EstadoPersonal estadoPersonal
) {}
