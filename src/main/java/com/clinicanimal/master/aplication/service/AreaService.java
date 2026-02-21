package com.clinicanimal.master.aplication.service;

import com.clinicanimal.master.web.dto.area.AreaRequestDto;
import com.clinicanimal.master.web.dto.area.AreaResponseDto;
import com.clinicanimal.master.web.dto.area.AreaUpdateDto;

import java.util.List;

public interface AreaService {
    List<AreaResponseDto> findAll();
    AreaResponseDto findById(Long id);
    AreaResponseDto crearArea(AreaRequestDto dto);
    AreaResponseDto actualizarArea(Long id, AreaUpdateDto dto);
    void eliminarArea(Long id);
}
