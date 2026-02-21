package com.clinicanimal.master.aplication.mapper;

import com.clinicanimal.master.domain.model.Areas;
import com.clinicanimal.master.web.dto.area.AreaRequestDto;
import com.clinicanimal.master.web.dto.area.AreaResponseDto;
import com.clinicanimal.master.web.dto.area.AreaUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AreaMapper {
    Areas toEntity(AreaRequestDto dto);
    AreaResponseDto toDto(Areas entity);
    void updateEntity(AreaUpdateDto dto, @MappingTarget Areas area);
}
