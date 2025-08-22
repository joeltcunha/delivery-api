package com.deliverytech.delivery_api.controller;

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

@CrossOrigin(origins = "*")

@RestController

@ResquestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDto> cadastrar(@RequestBody ClienteDto dto) {
        Long id = clienteService.cadastrarCliente(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        }
    }
    @PostMapping
    public ResponseEntity<Long> cadastrar(@RequestBody ClienteDto dto) {
        Long id = produtoService.cadastrarProduto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
}
