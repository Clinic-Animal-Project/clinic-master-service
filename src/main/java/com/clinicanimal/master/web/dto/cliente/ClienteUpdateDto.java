package com.clinicanimal.master.web.dto.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClienteUpdateDto(
        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 100, message = "El nombre no puede superar 100 caracteres")
        String nombre,

        @NotBlank(message = "El apellido es obligatorio")
        @Size(max = 100, message = "El apellido no puede superar 100 caracteres")
        String apellido,

        @NotBlank(message = "El telefono es obligatorio")
        @Pattern(regexp = "\\d{9,15}", message = "El telefono debe contener entre 9 y 15 digitos")
        String telefono,

        @NotBlank(message = "La direccion es obligatoria")
        @Size(max = 255, message = "La direccion no puede superar 255 caracteres")
        String direccion,

        @NotBlank(message = "El email es obligatorio")
        @Email(message = "El email no tiene un formato valido")
        String email
) {}
