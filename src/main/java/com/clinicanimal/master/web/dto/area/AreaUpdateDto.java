package com.clinicanimal.master.web.dto.area;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AreaUpdateDto(
        @NotBlank(message = "El nombre del area es obligatorio")
        @Size(max = 100, message = "El nombre del area no puede superar 100 caracteres")
        String nomArea,

        @NotBlank(message = "La descripcion es obligatoria")
        @Size(max = 255, message = "La descripcion no puede superar 255 caracteres")
        String descripcion
) {}
