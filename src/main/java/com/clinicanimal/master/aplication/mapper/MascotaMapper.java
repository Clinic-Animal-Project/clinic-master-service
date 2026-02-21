package com.clinicanimal.master.aplication.mapper;

import com.clinicanimal.master.domain.model.Mascota;
import com.clinicanimal.master.web.dto.mascota.MascotaRequestDto;
import com.clinicanimal.master.web.dto.mascota.MascotaResponseDto;
import com.clinicanimal.master.web.dto.mascota.MascotaUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MascotaMapper {

    @Mapping(target = "cliente.id", source = "idCliente")
    Mascota toEntity(MascotaRequestDto dto);

    @Mapping(target = "idCliente", source = "cliente.id")
    MascotaResponseDto toDto(Mascota entity);

    void updateEntity(MascotaUpdateDto dto, @MappingTarget Mascota mascota);
}
