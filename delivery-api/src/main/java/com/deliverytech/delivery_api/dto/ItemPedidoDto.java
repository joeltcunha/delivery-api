package com.deliverytech.delivery_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ItemPedidoDto {

    @NotNull
    private Long produtoId;

    @Min(1)
    private int quantidade;
}
