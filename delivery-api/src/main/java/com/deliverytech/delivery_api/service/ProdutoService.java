package com.deliverytech.delivery_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.deliverytech.delivery_api.dto.ProdutoDto;

@Service
public interface ProdutoService {
    public Long cadastrarProduto(ProdutoDto ProdutoDto);
    public List<ProdutoDto> buscarProdutosPorRestaurante(Long restauranteId);
    public ProdutoDto buscarProdutoPorId(Long id);
    public ProdutoDto atualizarProduto(Long id, ProdutoDto produtoDto);
    public ProdutoDto alterarDisponibilidade(Long id, boolean disponivel);
    public List<ProdutoDto> findProdutoByCategoria(String categoria);
    public List<ProdutoDto> findAll();

}
