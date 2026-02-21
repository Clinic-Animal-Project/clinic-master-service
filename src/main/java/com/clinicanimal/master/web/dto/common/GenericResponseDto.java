package com.clinicanimal.master.web.dto.common;

public record GenericResponseDto(
        Boolean success,
        String mensaje,
        Object data
) {
    public static GenericResponseDto ok(Object data) {
        return new GenericResponseDto(true, "Operación exitosa", data);
    }

    public static GenericResponseDto ok(String mensaje, Object data) {
        return new GenericResponseDto(true, mensaje, data);
    }

    public static GenericResponseDto error(String mensaje) {
        return new GenericResponseDto(false, mensaje, null);
    }
}
