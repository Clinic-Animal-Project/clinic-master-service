package com.clinicanimal.master.web.dto.personal;

import com.clinicanimal.master.domain.model.estado.EstadoPersonal;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record PersonalRequestDto(
        @NotBlank(message = "El nombre del personal es obligatorio")
        @Size(max = 100, message = "El nombre no puede superar 100 caracteres")
        String nombrePersonal,

        @NotBlank(message = "El apellido del personal es obligatorio")
        @Size(max = 100, message = "El apellido no puede superar 100 caracteres")
        String apellidoPersonal,

        @Min(value = 18, message = "La edad minima es 18 anios")
        int edad,

        @NotBlank(message = "El DNI es obligatorio")
        @Pattern(regexp = "\\d{8}", message = "El DNI debe tener exactamente 8 digitos")
        String dni,

        @NotBlank(message = "El email es obligatorio")
        @Email(message = "El email no tiene un formato valido")
        String email,

        @NotBlank(message = "El telefono es obligatorio")
        @Pattern(regexp = "\\d{9,15}", message = "El telefono debe contener entre 9 y 15 digitos")
        String telefono,

        @NotNull(message = "El id del rol es obligatorio")
        @Positive(message = "El id del rol debe ser un numero positivo")
        Long idRol,

        @NotNull(message = "El id del area es obligatorio")
        @Positive(message = "El id del area debe ser un numero positivo")
        Long idArea,

        @NotNull(message = "El estado del personal es obligatorio")
        EstadoPersonal estadoPersonal
) {}
