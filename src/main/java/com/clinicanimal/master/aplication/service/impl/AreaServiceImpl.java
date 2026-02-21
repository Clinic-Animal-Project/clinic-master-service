package com.clinicanimal.master.aplication.service.impl;

import com.clinicanimal.master.aplication.mapper.AreaMapper;
import com.clinicanimal.master.aplication.service.AreaService;
import com.clinicanimal.master.domain.model.Areas;
import com.clinicanimal.master.domain.repository.AreasRepository;
import com.clinicanimal.master.web.dto.area.AreaRequestDto;
import com.clinicanimal.master.web.dto.area.AreaResponseDto;
import com.clinicanimal.master.web.dto.area.AreaUpdateDto;
import com.clinicanimal.master.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements AreaService {

    private final AreaMapper areaMapper;
    private final AreasRepository areasRepository;

    @Override
    public List<AreaResponseDto> findAll() {
        return areasRepository.findAllByActiveTrue()
                .stream()
                .map(areaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AreaResponseDto findById(Long id) {
        return areaMapper.toDto(findEntityById(id));
    }

    @Override
    public AreaResponseDto crearArea(AreaRequestDto dto) {
        Areas area = areaMapper.toEntity(dto);
        Areas guardada = areasRepository.save(area);
        return areaMapper.toDto(guardada);
    }

    @Override
    public AreaResponseDto actualizarArea(Long id, AreaUpdateDto dto) {
        Areas area = findEntityById(id);
        areaMapper.updateEntity(dto, area);
        Areas actualizada = areasRepository.save(area);
        return areaMapper.toDto(actualizada);
    }

    @Override
    public void eliminarArea(Long id) {
        Areas area = findEntityById(id);
        area.setActive(false);
        areasRepository.save(area);
    }

    private Areas findEntityById(Long id) {
        return areasRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Area", id));
    }
}
