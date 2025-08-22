package com.deliverytech.delivery_api.service;

import java.math.BigDecimal;
import java.util.List;

import com.deliverytech.delivery_api.dto.ItemPedidoDto;
import com.deliverytech.delivery_api.dto.PedidoDto;

public interface IPedidoService {

    // Cria um novo pedido com base nos dados fornecidos
    PedidoResponseDto criarPedido(PedidoDto dto);

    // Busca um pedido específico pelo seu ID
    PedidoResponseDto buscarPedidoPorId(Long id);

    // Retorna todos os pedidos associados a um determinado cliente
    List<PedidoResponseDto> buscarPedidoPorCliente(Long clienteId);

    // Atualiza o status de um pedido (ex: PROCESSANDO, ENTREGUE, CANCELADO)
    PedidoResponseDto atualizarStatusPedido(Long id, StatusPedido status);

    // Calcula o valor total de um pedido com base nos itens informados
    BigDecimal calcularTotalPedido(List<ItemPedidoDto> itens);

    // Cancela um pedido, se permitido pelas regras de negócio
    void cancelarPedido(Long id);
}
