package com.deliverytech.delivery_api.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery_api.dto.PedidoDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/pedidos")

public class PedidoController {
    private final PedidoService service;

    public PedidoController(PedidoService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDto> criar(@RequestBody PedidoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarPedido(dto));
    }
}
