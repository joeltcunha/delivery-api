package com.deliverytech.delivery_api.service;

import java.util.List;

import com.deliverytech.delivery_api.dto.ClienteDto;
import com.deliverytech.delivery_api.dto.ClienteResponseDto;

public interface ClienteService {
    ClienteResponseDto cadastrarCliente(ClienteDto dto);
    ClienteResponseDto buscarClientePorId(Long id);
    ClienteResponseDto buscarClientePorEmail(String email);
    ClienteResponseDto atualizarCliente(Long id, ClienteDto dto);
    ClienteResponseDto ativarDesativarCliente(Long id);
    List<ClienteResponseDto> listarClientesAtivos();

}
