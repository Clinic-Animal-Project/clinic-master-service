package com.clinicanimal.master.aplication.service.impl;

import com.clinicanimal.master.aplication.mapper.RolesMapper;
import com.clinicanimal.master.aplication.service.RolesService;
import com.clinicanimal.master.domain.model.Roles;
import com.clinicanimal.master.domain.repository.RolesRepository;
import com.clinicanimal.master.web.dto.roles.RolesRequestDto;
import com.clinicanimal.master.web.dto.roles.RolesResponseDto;
import com.clinicanimal.master.web.dto.roles.RolesUpdateDto;
import com.clinicanimal.master.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesService {

    private final RolesMapper rolesMapper;
    private final RolesRepository rolesRepository;

    @Override
    public List<RolesResponseDto> findAll() {
        return rolesRepository.findAllByActiveTrue()
                .stream()
                .map(rolesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RolesResponseDto findById(Long id) {
        return rolesMapper.toDto(findEntityById(id));
    }

    @Override
    public RolesResponseDto crearRol(RolesRequestDto dto) {
        Roles rol = rolesMapper.toEntity(dto);
        Roles guardado = rolesRepository.save(rol);
        return rolesMapper.toDto(guardado);
    }

    @Override
    public RolesResponseDto actualizarRol(Long id, RolesUpdateDto dto) {
        Roles rol = findEntityById(id);
        rolesMapper.updateEntity(dto, rol);
        Roles actualizado = rolesRepository.save(rol);
        return rolesMapper.toDto(actualizado);
    }

    @Override
    public void eliminarRol(Long id) {
        Roles rol = findEntityById(id);
        rol.setActive(false);
        rolesRepository.save(rol);
    }

    private Roles findEntityById(Long id) {
        return rolesRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol", id));
    }
}
