package com.deliverytech.delivery_api.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PedidoDto {
    
    @NotNull
    private Long clienteId;

    @NotNull
    private Long restauranteId;

    @NotBlank
    private String enderecoEntrega;

    @Valid
    @NotEmpty
    private List<ItemPedidoDto> itens;
}
