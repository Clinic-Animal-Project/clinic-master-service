package com.clinicanimal.master.aplication.service;

import com.clinicanimal.master.web.dto.cliente.ClienteRequestDto;
import com.clinicanimal.master.web.dto.cliente.ClienteResponseDto;
import com.clinicanimal.master.web.dto.cliente.ClienteUpdateDto;

import java.util.List;

public interface ClienteService {
    List<ClienteResponseDto> findAll();
    ClienteResponseDto findById(Long id);
    ClienteResponseDto crearCliente(ClienteRequestDto dto);
    ClienteResponseDto actualizarCliente(Long id, ClienteUpdateDto dto);
    void eliminarCliente(Long id);
}
