package com.clinicanimal.master.aplication.mapper;

import com.clinicanimal.master.domain.model.Servicios;
import com.clinicanimal.master.web.dto.servicios.ServiciosRequestDto;
import com.clinicanimal.master.web.dto.servicios.ServiciosResponseDto;
import com.clinicanimal.master.web.dto.servicios.ServiciosUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ServiciosMapper {

    @Mapping(target = "area.id", source = "codigoArea")
    Servicios toEntity(ServiciosRequestDto dto);

    @Mapping(target = "codigoArea", source = "area.id")
    @Mapping(target = "nomArea", source = "area.nomArea")
    ServiciosResponseDto toDto(Servicios entity);

    @Mapping(target = "area.id", source = "codigoArea")
    void updateEntity(ServiciosUpdateDto dto, @MappingTarget Servicios servicio);
}
