package com.clinicanimal.master.aplication.service.impl;

import com.clinicanimal.master.aplication.mapper.ServiciosMapper;
import com.clinicanimal.master.aplication.service.ServiciosService;
import com.clinicanimal.master.domain.model.Servicios;
import com.clinicanimal.master.domain.repository.ServiciosRepository;
import com.clinicanimal.master.web.dto.servicios.ServiciosRequestDto;
import com.clinicanimal.master.web.dto.servicios.ServiciosResponseDto;
import com.clinicanimal.master.web.dto.servicios.ServiciosUpdateDto;
import com.clinicanimal.master.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiciosServiceImpl implements ServiciosService {

    private final ServiciosMapper serviciosMapper;
    private final ServiciosRepository serviciosRepository;

    @Override
    public List<ServiciosResponseDto> findAll() {
        return serviciosRepository.findAllByActiveTrue()
                .stream()
                .map(serviciosMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ServiciosResponseDto findById(Long id) {
        return serviciosMapper.toDto(findEntityById(id));
    }

    @Override
    public ServiciosResponseDto crearServicio(ServiciosRequestDto dto) {
        Servicios servicio = serviciosMapper.toEntity(dto);
        Servicios guardado = serviciosRepository.save(servicio);
        return serviciosMapper.toDto(guardado);
    }

    @Override
    public ServiciosResponseDto actualizarServicio(Long id, ServiciosUpdateDto dto) {
        Servicios servicio = findEntityById(id);
        serviciosMapper.updateEntity(dto, servicio);
        Servicios actualizado = serviciosRepository.save(servicio);
        return serviciosMapper.toDto(actualizado);
    }

    @Override
    public void eliminarServicio(Long id) {
        Servicios servicio = findEntityById(id);
        servicio.setActive(false);
        serviciosRepository.save(servicio);
    }

    private Servicios findEntityById(Long id) {
        return serviciosRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio", id));
    }
}
