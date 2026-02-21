package com.clinicanimal.master.web.dto.servicios;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ServiciosRequestDto(
        @NotBlank(message = "El nombre del servicio es obligatorio")
        @Size(max = 100, message = "El nombre no puede superar 100 caracteres")
        String nombre,

        @NotBlank(message = "La descripcion es obligatoria")
        @Size(max = 255, message = "La descripcion no puede superar 255 caracteres")
        String descripcion,

        @NotNull(message = "La duracion es obligatoria")
        @Positive(message = "La duracion debe ser un numero positivo")
        Integer duracion,

        @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor a 0")
        double precio,

        boolean activo,

        @NotNull(message = "El codigo del area es obligatorio")
        @Positive(message = "El codigo del area debe ser un numero positivo")
        Long codigoArea
) {}
