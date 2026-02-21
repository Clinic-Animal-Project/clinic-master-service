package com.clinicanimal.master.aplication.service;

import com.clinicanimal.master.domain.model.estado.EstadoPersonal;
import com.clinicanimal.master.web.dto.personal.PersonalRequestDto;
import com.clinicanimal.master.web.dto.personal.PersonalResponseDto;
import com.clinicanimal.master.web.dto.personal.PersonalUpdateDto;

import java.util.List;

public interface PersonalService {
    List<PersonalResponseDto> findAll();
    PersonalResponseDto findById(Long id);
    PersonalResponseDto crearPersonal(PersonalRequestDto dto);
    PersonalResponseDto actualizarPersonal(Long id, PersonalUpdateDto dto);
    void eliminarPersonal(Long id);

    PersonalResponseDto actualizarEstado(Long id, EstadoPersonal estadoPersonal);
}
