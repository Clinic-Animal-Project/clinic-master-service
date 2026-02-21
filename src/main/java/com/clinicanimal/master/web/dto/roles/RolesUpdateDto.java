package com.clinicanimal.master.web.dto.roles;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RolesUpdateDto(
        @NotBlank(message = "El nombre del rol es obligatorio")
        @Size(max = 100, message = "El nombre del rol no puede superar 100 caracteres")
        String rolNombre,

        @NotBlank(message = "La descripcion es obligatoria")
        @Size(max = 255, message = "La descripcion no puede superar 255 caracteres")
        String descripcion,

        boolean accesoWeb
) {}
