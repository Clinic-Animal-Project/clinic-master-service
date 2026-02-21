package com.clinicanimal.master.aplication.mapper;

import com.clinicanimal.master.domain.model.Personal;
import com.clinicanimal.master.web.dto.personal.PersonalRequestDto;
import com.clinicanimal.master.web.dto.personal.PersonalResponseDto;
import com.clinicanimal.master.web.dto.personal.PersonalUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PersonalMapper {

    @Mapping(target = "roles.id", source = "idRol")
    @Mapping(target = "areas.id", source = "idArea")
    Personal toEntity(PersonalRequestDto dto);

    @Mapping(target = "idRol", source = "roles.id")
    @Mapping(target = "nombreRol", source = "roles.rolNombre")
    @Mapping(target = "idArea", source = "areas.id")
    @Mapping(target = "nomArea", source = "areas.nomArea")
    PersonalResponseDto toDto(Personal entity);

    @Mapping(target = "roles.id", source = "idRol")
    @Mapping(target = "areas.id", source = "idArea")
    void updateEntity(PersonalUpdateDto dto, @MappingTarget Personal personal);
}
