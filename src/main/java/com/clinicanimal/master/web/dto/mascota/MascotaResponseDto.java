package com.clinicanimal.master.web.dto.mascota;

public record MascotaResponseDto(
        Long id,
        String nombre,
        String especie,
        String raza,
        int edad,
        String sexo,
        Long idCliente
) {}
