package com.deliverytech.delivery_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery_api.dto.ClienteDto;
import com.deliverytech.delivery_api.dto.ClienteResponseDto;
import com.deliverytech.delivery_api.dto.ProdutoDto;
import com.deliverytech.delivery_api.service.ClienteService;

import jakarta.validation.Valid;
@RestController
@ResquestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
    @Autowired
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    
    @PostMapping
    public ResponseEntity<ClienteResponseDto> cadastrar(@RequestBody ClienteDto dto) {
    //   Chama o serviço para cadastrar o cliente e retorna HTTP 201 (Created)
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarCliente(dto));
    }
}
