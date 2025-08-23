package com.deliverytech.delivery_api.pedido.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.ItemPedidoDto;
import com.deliverytech.delivery_api.dto.PedidoResponseDto;
import com.deliverytech.delivery_api.entity.Cliente;
import com.deliverytech.delivery_api.entity.ItemPedido;
import com.deliverytech.delivery_api.entity.Produto;
import com.deliverytech.delivery_api.entity.StatusPedido;
import com.deliverytech.delivery_api.exception.BusinessException;
import com.deliverytech.delivery_api.pedido.dto.PedidoDto;
import com.deliverytech.delivery_api.pedido.entity.Pedido;
import com.deliverytech.delivery_api.pedido.repository.IPedidoRepository;
import com.deliverytech.delivery_api.repository.IClienteRepository;
import com.deliverytech.delivery_api.repository.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoServiceImpl implements IPedidoService{

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private IPedidoRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    public PedidoServiceImpl(IPedidoRepository repository, IClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.repository = repository;

        this.clienteRepository = clienteRepository;

        this.produtoRepository = produtoRepository;
    }


    @Override
    public PedidoResponseDto criarPedido(PedidoDto dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElseThrow(()-> new EntityNotFoundException("Cliente não encontrado."));

        List<ItemPedido> itensPedido = new ArrayList<>();
        BigDecimal subtotal = BigDecimal.ZERO;

        for (ItemPedidoDto itemDto : dto.getItens()) {
            Produto produto = produtoRepository.findById(itemDto.getProdutoId())
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado: " + itemDto.getProdutoId()));
            
            if (!produto.isDisponivel()) {
                throw new BusinessException("Produto indisponível: " + produto.getNome());
            }
            if (!produto.getRestaurante().getId().equals(dto.getRestauranteId())) {
                throw new BusinessException("Produto não pertence ao restaurante selecionado.");
            }
            // Criar item do pedido
            ItemPedido item = new ItemPedido();
            item.setProduto(produto);
            item.setQuantidade(itemDto.getQuantidade());
            item.setPrecoUnitario(produto.getPreco());
            item.setSubtotal(produto.getPreco().multiply(BigDecimal.valueOf(itemDto.getQuantidade())));

            itensPedido.add(item);
            subtotal = subtotal.add(item.getSubtotal());
        }
        // Calcular total do pedido
        // BigDecimal taxaEntrega = restaurante.getTaxaEntrega();
        // BigDecimal valorTotal = subtotal.add(taxaEntrega);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        // pedido.setRestaurante(restaurante);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedido.PENDENTE);
        pedido.setEnderecoEntrega(dto.getEnderecoEntrega());
        pedido.setSubtotal(subtotal);
        // pedido.setTaxaEntrega(taxaEntrega);
        // pedido.setValorTotal(valorTotal);
        
        ModelMapper modelMapper = new ModelMapper();
        PedidoResponseDto pedidoResponseDto= modelMapper.map(pedido, PedidoResponseDto.class);
        return pedidoResponseDto;
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
