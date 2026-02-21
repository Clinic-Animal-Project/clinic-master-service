package com.clinicanimal.master.aplication.mapper;

import com.clinicanimal.master.domain.model.Cliente;
import com.clinicanimal.master.web.dto.cliente.ClienteRequestDto;
import com.clinicanimal.master.web.dto.cliente.ClienteResponseDto;
import com.clinicanimal.master.web.dto.cliente.ClienteUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente toEntity(ClienteRequestDto dto);
    ClienteResponseDto toResponse(Cliente cliente);
    void updateEntity(ClienteUpdateDto dto, @MappingTarget Cliente cliente);
}
