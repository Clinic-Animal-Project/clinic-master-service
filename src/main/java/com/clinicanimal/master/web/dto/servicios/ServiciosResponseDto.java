package com.clinicanimal.master.web.dto.servicios;

public record ServiciosResponseDto(
        Long id,
        String nombre,
        String descripcion,
        Integer duracion,
        double precio,
        boolean active,
        Long codigoArea,
        String nomArea
) {}
