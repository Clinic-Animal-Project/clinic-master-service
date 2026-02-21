package com.clinicanimal.master.aplication.service.impl;

import com.clinicanimal.master.aplication.mapper.ClienteMapper;
import com.clinicanimal.master.aplication.service.ClienteService;
import com.clinicanimal.master.domain.model.Cliente;
import com.clinicanimal.master.domain.repository.ClienteRepository;
import com.clinicanimal.master.web.dto.cliente.ClienteRequestDto;
import com.clinicanimal.master.web.dto.cliente.ClienteResponseDto;
import com.clinicanimal.master.web.dto.cliente.ClienteUpdateDto;
import com.clinicanimal.master.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private  final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;

    @Override
    public List<ClienteResponseDto> findAll() {
        return clienteRepository.findAllByActiveTrue()
                .stream()
                .map(clienteMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteResponseDto findById(Long id) {
        return clienteMapper.toResponse(findEntityById(id));
    }

    @Override
    public ClienteResponseDto crearCliente(ClienteRequestDto dto) {
        Cliente cliente = clienteMapper.toEntity(dto);
        Cliente guardado = clienteRepository.save(cliente);
        return clienteMapper.toResponse(guardado);
    }

    @Override
    public ClienteResponseDto actualizarCliente(Long id, ClienteUpdateDto dto) {
        Cliente cliente = findEntityById(id);
        clienteMapper.updateEntity(dto, cliente);
        Cliente actualizado = clienteRepository.save(cliente);
        return clienteMapper.toResponse(actualizado);
    }

    @Override
    public void eliminarCliente(Long id) {
        Cliente cliente = findEntityById(id);
        cliente.setActive(false);
        clienteRepository.save(cliente);
    }

    private Cliente findEntityById(Long id) {
        return clienteRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", id));
    }
}
