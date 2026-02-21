package com.clinicanimal.master.aplication.service;

import com.clinicanimal.master.web.dto.roles.RolesRequestDto;
import com.clinicanimal.master.web.dto.roles.RolesResponseDto;
import com.clinicanimal.master.web.dto.roles.RolesUpdateDto;

import java.util.List;

public interface RolesService {
    List<RolesResponseDto> findAll();
    RolesResponseDto findById(Long id);
    RolesResponseDto crearRol(RolesRequestDto dto);
    RolesResponseDto actualizarRol(Long id, RolesUpdateDto dto);
    void eliminarRol(Long id);
}
