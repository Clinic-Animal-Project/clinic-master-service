package com.clinicanimal.master.aplication.service;

import com.clinicanimal.master.web.dto.servicios.ServiciosRequestDto;
import com.clinicanimal.master.web.dto.servicios.ServiciosResponseDto;
import com.clinicanimal.master.web.dto.servicios.ServiciosUpdateDto;

import java.util.List;

public interface ServiciosService {
    List<ServiciosResponseDto> findAll();
    ServiciosResponseDto findById(Long id);
    ServiciosResponseDto crearServicio(ServiciosRequestDto dto);
    ServiciosResponseDto actualizarServicio(Long id, ServiciosUpdateDto dto);
    void eliminarServicio(Long id);
}
