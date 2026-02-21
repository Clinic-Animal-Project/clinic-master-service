package com.clinicanimal.master.web.dto.mascota;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MascotaUpdateDto(
        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 100, message = "El nombre no puede superar 100 caracteres")
        String nombre,

        @NotBlank(message = "La especie es obligatoria")
        @Size(max = 100, message = "La especie no puede superar 100 caracteres")
        String especie,

        @NotBlank(message = "La raza es obligatoria")
        @Size(max = 100, message = "La raza no puede superar 100 caracteres")
        String raza,

        @Min(value = 0, message = "La edad no puede ser negativa")
        int edad,

        @NotBlank(message = "El sexo es obligatorio")
        String sexo
) {}
