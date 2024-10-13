package com.wearit.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wearit.projeto.dto.ProdutoDTO;
import com.wearit.projeto.entity.ProdutoEntity;
import com.wearit.projeto.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Listar todos os produtos
    public List<ProdutoDTO> listarTodos() {
        List<ProdutoEntity> produtos = produtoRepository.findAll();
        return produtos.stream().map(ProdutoDTO::new).toList();
    }

    // Inserir novo produto
    public void inserir(ProdutoDTO produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity(produto);
        produtoRepository.save(produtoEntity);
    }

    // Alterar produto existente
    public ProdutoDTO alterar(ProdutoDTO produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity(produto);
        return new ProdutoDTO(produtoRepository.save(produtoEntity));
    }

    // Excluir produto por ID
    public void excluir(Long id) {
        ProdutoEntity produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produtoRepository.delete(produto);
    }

    // Buscar produto por ID
    public ProdutoDTO buscarPorId(Long id) {
        ProdutoEntity produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return new ProdutoDTO(produto);
    }
}
