package com.deliverytech.delivery_api.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.ItemPedidoDto;
import com.deliverytech.delivery_api.dto.PedidoDto;
import com.deliverytech.delivery_api.entity.StatusPedido;
import com.deliverytech.delivery_api.repository.ProdutoRepository;

@Service
public class PedidoServiceImpl implements IPedidoService{

    @Autowired
    private PedidoRepository repository;
    public PedidoServiceImpl(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public PedidoResponseDto criarPedido(PedidoDto dto) {
       
    }

    @Override
    public PedidoResponseDto buscarPedidoPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPedidoPorId'");
    }

    @Override
    public List<PedidoResponseDto> buscarPedidoPorCliente(Long clienteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPedidoPorCliente'");
    }

    @Override
    public PedidoResponseDto atualizarStatusPedido(Long id, StatusPedido status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarStatusPedido'");
    }

    @Override
    public BigDecimal calcularTotalPedido(List<ItemPedidoDto> itens) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularTotalPedido'");
    }

    @Override
    public void cancelarPedido(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelarPedido'");
    }

}
