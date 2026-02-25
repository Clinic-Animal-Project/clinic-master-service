package com.clinicanimal.master.aplication.service.impl;

import com.clinicanimal.master.aplication.mapper.MascotaMapper;
import com.clinicanimal.master.aplication.service.MascotaService;
import com.clinicanimal.master.domain.model.Mascota;
import com.clinicanimal.master.domain.repository.MascotaRepository;
import com.clinicanimal.master.web.dto.mascota.MascotaRequestDto;
import com.clinicanimal.master.web.dto.mascota.MascotaResponseDto;
import com.clinicanimal.master.web.dto.mascota.MascotaUpdateDto;
import com.clinicanimal.master.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService {

    private final MascotaMapper mascotaMapper;
    private final MascotaRepository mascotaRepository;

    @Override
    public List<MascotaResponseDto> findAll(String nombre) {
        String filtro = (nombre == null) ? "" : nombre.trim();

        return mascotaRepository.findAllByNombreFiltro(filtro)
                .stream()
                .map(mascotaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MascotaResponseDto findById(Long id) {
        return mascotaMapper.toDto(findEntityById(id));
    }

    @Override
    public MascotaResponseDto crearMascota(MascotaRequestDto dto) {
        Mascota mascota = mascotaMapper.toEntity(dto);
        Mascota guardada = mascotaRepository.save(mascota);
        return mascotaMapper.toDto(guardada);
    }

    @Override
    public MascotaResponseDto actualizarMascota(Long id, MascotaUpdateDto dto) {
        Mascota mascota = findEntityById(id);
        mascotaMapper.updateEntity(dto, mascota);
        Mascota actualizada = mascotaRepository.save(mascota);
        return mascotaMapper.toDto(actualizada);
    }

    @Override
    public void eliminarMascota(Long id) {
        Mascota mascota = findEntityById(id);
        mascota.setActive(false);
        mascotaRepository.save(mascota);
    }

    @Override
    public List<MascotaResponseDto> listarMascotaPorCliente(Long idCliente) {
        return mascotaRepository.findAllByClienteIdAndActiveTrue(idCliente)
                .stream()
                .map(mascotaMapper::toDto)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<MascotaResponseDto> listarMascotaPorNombre(String nombre) {
//        return mascotaRepository.findAllByNombreAndActiveTrue(nombre)
//                .stream()
//                .map(mascotaMapper::toDto)
//                .collect(Collectors.toList());
//    }

    private Mascota findEntityById(Long id) {
        return mascotaRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mascota", id));
    }
}
