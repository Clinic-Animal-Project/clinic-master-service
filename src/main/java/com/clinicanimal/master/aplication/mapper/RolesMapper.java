package com.clinicanimal.master.aplication.mapper;

import com.clinicanimal.master.domain.model.Roles;
import com.clinicanimal.master.web.dto.roles.RolesRequestDto;
import com.clinicanimal.master.web.dto.roles.RolesResponseDto;
import com.clinicanimal.master.web.dto.roles.RolesUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RolesMapper {
    Roles toEntity(RolesRequestDto dto);
    RolesResponseDto toDto(Roles entity);
    void updateEntity(RolesUpdateDto dto, @MappingTarget Roles roles);
}
