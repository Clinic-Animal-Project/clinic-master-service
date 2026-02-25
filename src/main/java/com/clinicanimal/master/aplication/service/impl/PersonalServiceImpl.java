package com.clinicanimal.master.aplication.service.impl;

import com.clinicanimal.master.aplication.mapper.PersonalMapper;
import com.clinicanimal.master.aplication.service.PersonalService;
import com.clinicanimal.master.domain.model.Personal;
import com.clinicanimal.master.domain.model.estado.EstadoPersonal;
import com.clinicanimal.master.domain.repository.PersonalRepository;
import com.clinicanimal.master.web.dto.personal.PersonalRequestDto;
import com.clinicanimal.master.web.dto.personal.PersonalResponseDto;
import com.clinicanimal.master.web.dto.personal.PersonalUpdateDto;
import com.clinicanimal.master.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonalServiceImpl implements PersonalService {

    private final PersonalMapper personalMapper;
    private final PersonalRepository personalRepository;

    @Override
    public List<PersonalResponseDto> findAll() {

        return personalRepository.findAllByActiveTrue()
                .stream()
                .map(personalMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersonalResponseDto findById(Long id) {
        return personalMapper.toDto(findEntityById(id));
    }

    @Override
    public PersonalResponseDto crearPersonal(PersonalRequestDto dto) {
        Personal personal = personalMapper.toEntity(dto);
        personal.setFechaRegistro(LocalDate.now());
        Personal guardado = personalRepository.save(personal);
        return personalMapper.toDto(guardado);
    }

    @Override
    public PersonalResponseDto actualizarPersonal(Long id, PersonalUpdateDto dto) {
        Personal personal = findEntityById(id);
        personalMapper.updateEntity(dto, personal);
        Personal actualizado = personalRepository.save(personal);
        return personalMapper.toDto(actualizado);
    }

    @Override
    public void eliminarPersonal(Long id) {
        Personal personal = findEntityById(id);
        personal.setActive(false);
        personalRepository.save(personal);
    }

    @Override
    public PersonalResponseDto actualizarEstado(Long id, EstadoPersonal estadoPersonal) {
        Personal personal = findEntityById(id);
        personal.setEstadoPersonal(estadoPersonal);
        personalRepository.save(personal);
        return personalMapper.toDto(personal);
    }

    private Personal findEntityById(Long id) {
        return personalRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personal", id));
    }
}
