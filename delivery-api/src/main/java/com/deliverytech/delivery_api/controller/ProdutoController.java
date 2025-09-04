package com.deliverytech.delivery_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery_api.dto.ProdutoDto;
import com.deliverytech.delivery_api.service.ProdutoService;

@CrossOrigin(origins = "*")

@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
 
   // @RequestMapping("/findAll")
    @GetMapping("/findAll")
    public List<ProdutoDto> getAllProducts() {        
        return produtoService.findAll();
    }
    @PostMapping
    public ResponseEntity<Long> cadastrarProduto(@RequestBody ProdutoDto dto) {
        Long id = produtoService.cadastrarProduto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PatchMapping("/{id}/produto")
    public ResponseEntity<ProdutoDto> atualizarProduto(@RequestBody ProdutoDto produtoDto, Long id) {
        ProdutoDto produtoSalvo = produtoService.atualizarProduto(id, produtoDto);
        return ResponseEntity.ok(produtoSalvo);
    }

    @GetMapping("byCategoria")
    public ResponseEntity<List<ProdutoDto>> findProdutoByCategoria(@RequestParam("query") String categoria) {
        List<ProdutoDto> produtoDto = produtoService.findProdutoByCategoria(categoria);
        return ResponseEntity.ok(produtoDto);
    }
}