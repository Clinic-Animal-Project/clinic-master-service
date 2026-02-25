package com.clinicanimal.master.aplication.service;

import com.clinicanimal.master.web.dto.mascota.MascotaRequestDto;
import com.clinicanimal.master.web.dto.mascota.MascotaResponseDto;
import com.clinicanimal.master.web.dto.mascota.MascotaUpdateDto;

import java.util.List;

public interface MascotaService {
    List<MascotaResponseDto> findAll(String nombre);
    MascotaResponseDto findById(Long id);
    MascotaResponseDto crearMascota(MascotaRequestDto dto);
    MascotaResponseDto actualizarMascota(Long id, MascotaUpdateDto dto);
    void eliminarMascota(Long id);

    List<MascotaResponseDto> listarMascotaPorCliente(Long idCliente);
//    List<MascotaResponseDto> listarMascotaPorNombre(String nombre);
}

