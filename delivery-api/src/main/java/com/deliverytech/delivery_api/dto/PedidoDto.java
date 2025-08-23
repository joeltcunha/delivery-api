package com.deliverytech.delivery_api.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

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
    @NotBlank(message = "Forma de pagamento é obrigatória")
    @Pattern(regexp = "^(DINHEIRO|CARTAO_CREDITO|CARTAO_DEBITO|PIX)$",
             message = "Forma de pagamento deve ser: DINHEIRO, CARTAO_CREDITO, CARTAO_DEBITO ou PIX")
             
    private String formaPagamento;
}
