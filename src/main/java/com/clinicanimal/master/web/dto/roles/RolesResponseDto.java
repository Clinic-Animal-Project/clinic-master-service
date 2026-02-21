package com.clinicanimal.master.web.dto.roles;

public record RolesResponseDto(
        Long id,
        String rolNombre,
        String descripcion,
        boolean accesoWeb
) {}
